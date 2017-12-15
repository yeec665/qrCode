package hiro;

public class FinalMixer {

    private String mStr;
    private QRVersion qrv;
    private int n;
    private PositionDetectionPattern mPdp;
    private PrimaryInformation mPi;
    private DataMask mDm;
    private DataArray mDa;

    public FinalMixer(String str) {
        mStr = str;
    }

    public void build(int ecLevel, int maskPattern) {
        if (maskPattern >= 0 && maskPattern < 8) {
            buildWithMaskPattern(ecLevel, maskPattern);
        } else {
            buildWithOutMaskPattern(ecLevel);
        }
    }

    private void buildWithMaskPattern(int ecLevel, int maskPattern) {
        Content sContent = new Content(mStr);
        qrv = sContent.getVersion(ecLevel, maskPattern);
        System.out.println(qrv);
        n = qrv.sideLength();
        mPdp = new PositionDetectionPattern(qrv);
        mPi = new PrimaryInformation(qrv);
        mDm = new DataMask(qrv);
        PaddedContent pContent = new PaddedContent(qrv, sContent);
        mDa = new DataArray(ErrorCorrectionTable.intoBlocks(qrv, pContent.getRaw()));
    }

    private void buildWithOutMaskPattern(int ecLevel) {
        Content sContent = new Content(mStr);
        qrv = sContent.getVersion(ecLevel);
        n = qrv.sideLength();
        mPdp = new PositionDetectionPattern(qrv);
        PaddedContent pContent = new PaddedContent(qrv, sContent);
        mDa = new DataArray(ErrorCorrectionTable.intoBlocks(qrv, pContent.getRaw()));
        int bestMaskPattern = 0, minPenaltyScore = Integer.MAX_VALUE;
        for (int i = 0; i < 8; i++) {
            qrv.setMaskPattern(i);
            mPi = new PrimaryInformation(qrv);
            mDm = new DataMask(qrv);
            PenaltyEvaluator evaluator = new PenaltyEvaluator();
            evaluator.setSize(n);
            write(evaluator);
            int score = evaluator.penaltyScore();
            if (score < minPenaltyScore) {
                minPenaltyScore = score;
                bestMaskPattern = i;
            }
        }
        qrv.setMaskPattern(bestMaskPattern);
        System.out.println(qrv);
        mPi = new PrimaryInformation(qrv);
        mDm = new DataMask(qrv);
    }

    public QRVersion getQrv() {
        return qrv;
    }

    public void write(QRHolder holder) {
        holder.setSize(n);
        CoordinateIterator ci = new CoordinateIterator(n);
        mDa.rewind();
        do {
            int x = ci.x(), y = ci.y();
            if (mPdp.valid(x, y)) {
                holder.putData(x, y, mPdp.read(x, y));
            } else if (mPi.valid(x, y)) {
                holder.putData(x, y, mPi.read(x, y));
            } else {
                holder.putData(x, y, mDa.next() ^ mDm.read(x, y));
            }
            //System.out.printf("(%d, %d)\n", x, y);
        } while (ci.next());
    }
}
