package hiro;

public class ErrorCorrectionTable {

    /**
     * https://www.thonky.com/qr-code-tutorial/error-correction-table
     */
    private static final ErrorCorrectionTableRow[] TABLE_ROWS = {
            new ErrorCorrectionTableRow(19, 7, 1, 19, 19),
//1-M
            new ErrorCorrectionTableRow(16, 10, 1, 16, 16),
//1-Q
            new ErrorCorrectionTableRow(13, 13, 1, 13, 13),
//1-H
            new ErrorCorrectionTableRow(9, 17, 1, 9, 9),
//2-L
            new ErrorCorrectionTableRow(34, 10, 1, 34, 34),
//2-M
            new ErrorCorrectionTableRow(28, 16, 1, 28, 28),
//2-Q
            new ErrorCorrectionTableRow(22, 22, 1, 22, 22),
//2-H
            new ErrorCorrectionTableRow(16, 28, 1, 16, 16),
//3-L
            new ErrorCorrectionTableRow(55, 15, 1, 55, 55),
//3-M
            new ErrorCorrectionTableRow(44, 26, 1, 44, 44),
//3-Q
            new ErrorCorrectionTableRow(34, 18, 2, 17, 34),
//3-H
            new ErrorCorrectionTableRow(26, 22, 2, 13, 26),
//4-L
            new ErrorCorrectionTableRow(80, 20, 1, 80, 80),
//4-M
            new ErrorCorrectionTableRow(64, 18, 2, 32, 64),
//4-Q
            new ErrorCorrectionTableRow(48, 26, 2, 24, 48),
//4-H
            new ErrorCorrectionTableRow(36, 16, 4, 9, 36),
//5-L
            new ErrorCorrectionTableRow(108, 26, 1, 108, 108),
//5-M
            new ErrorCorrectionTableRow(86, 24, 2, 43, 86),
//5-Q
            new ErrorCorrectionTableRow(62, 18, 2, 15, 2, 16, 62),
//5-H
            new ErrorCorrectionTableRow(46, 22, 2, 11, 2, 12, 46),
//6-L
            new ErrorCorrectionTableRow(136, 18, 2, 68, 136),
//6-M
            new ErrorCorrectionTableRow(108, 16, 4, 27, 108),
//6-Q
            new ErrorCorrectionTableRow(76, 24, 4, 19, 76),
//6-H
            new ErrorCorrectionTableRow(60, 28, 4, 15, 60),
//7-L
            new ErrorCorrectionTableRow(156, 20, 2, 78, 156),
//7-M
            new ErrorCorrectionTableRow(124, 18, 4, 31, 124),
//7-Q
            new ErrorCorrectionTableRow(88, 18, 2, 14, 4, 15, 88),
//7-H
            new ErrorCorrectionTableRow(66, 26, 4, 13, 1, 14, 66),
//8-L
            new ErrorCorrectionTableRow(194, 24, 2, 97, 194),
//8-M
            new ErrorCorrectionTableRow(154, 22, 2, 38, 2, 39, 154),
//8-Q
            new ErrorCorrectionTableRow(110, 22, 4, 18, 2, 19, 110),
//8-H
            new ErrorCorrectionTableRow(86, 26, 4, 14, 2, 15, 86),
//9-L
            new ErrorCorrectionTableRow(232, 30, 2, 116, 232),
//9-M
            new ErrorCorrectionTableRow(182, 22, 3, 36, 2, 37, 182),
//9-Q
            new ErrorCorrectionTableRow(132, 20, 4, 16, 4, 17, 132),
//9-H
            new ErrorCorrectionTableRow(100, 24, 4, 12, 4, 13, 100),
//10-L
            new ErrorCorrectionTableRow(274, 18, 2, 68, 2, 69, 274),
//10-M
            new ErrorCorrectionTableRow(216, 26, 4, 43, 1, 44, 216),
//10-Q
            new ErrorCorrectionTableRow(154, 24, 6, 19, 2, 20, 154),
//10-H
            new ErrorCorrectionTableRow(122, 28, 6, 15, 2, 16, 122),
//11-L
            new ErrorCorrectionTableRow(324, 20, 4, 81, 324),
//11-M
            new ErrorCorrectionTableRow(254, 30, 1, 50, 4, 51, 254),
//11-Q
            new ErrorCorrectionTableRow(180, 28, 4, 22, 4, 23, 180),
//11-H
            new ErrorCorrectionTableRow(140, 24, 3, 12, 8, 13, 140),
//12-L
            new ErrorCorrectionTableRow(370, 24, 2, 92, 2, 93, 370),
//12-M
            new ErrorCorrectionTableRow(290, 22, 6, 36, 2, 37, 290),
//12-Q
            new ErrorCorrectionTableRow(206, 26, 4, 20, 6, 21, 206),
//12-H
            new ErrorCorrectionTableRow(158, 28, 7, 14, 4, 15, 158),
//13-L
            new ErrorCorrectionTableRow(428, 26, 4, 107, 428),
//13-M
            new ErrorCorrectionTableRow(334, 22, 8, 37, 1, 38, 334),
//13-Q
            new ErrorCorrectionTableRow(244, 24, 8, 20, 4, 21, 244),
//13-H
            new ErrorCorrectionTableRow(180, 22, 12, 11, 4, 12, 180),
//14-L
            new ErrorCorrectionTableRow(461, 30, 3, 115, 1, 116, 461),
//14-M
            new ErrorCorrectionTableRow(365, 24, 4, 40, 5, 41, 365),
//14-Q
            new ErrorCorrectionTableRow(261, 20, 11, 16, 5, 17, 261),
//14-H
            new ErrorCorrectionTableRow(197, 24, 11, 12, 5, 13, 197),
//15-L
            new ErrorCorrectionTableRow(523, 22, 5, 87, 1, 88, 523),
//15-M
            new ErrorCorrectionTableRow(415, 24, 5, 41, 5, 42, 415),
//15-Q
            new ErrorCorrectionTableRow(295, 30, 5, 24, 7, 25, 295),
//15-H
            new ErrorCorrectionTableRow(223, 24, 11, 12, 7, 13, 223),
//16-L
            new ErrorCorrectionTableRow(589, 24, 5, 98, 1, 99, 589),
//16-M
            new ErrorCorrectionTableRow(453, 28, 7, 45, 3, 46, 453),
//16-Q
            new ErrorCorrectionTableRow(325, 24, 15, 19, 2, 20, 325),
//16-H
            new ErrorCorrectionTableRow(253, 30, 3, 15, 13, 16, 253),
//17-L
            new ErrorCorrectionTableRow(647, 28, 1, 107, 5, 108, 647),
//17-M
            new ErrorCorrectionTableRow(507, 28, 10, 46, 1, 47, 507),
//17-Q
            new ErrorCorrectionTableRow(367, 28, 1, 22, 15, 23, 367),
//17-H
            new ErrorCorrectionTableRow(283, 28, 2, 14, 17, 15, 283),
//18-L
            new ErrorCorrectionTableRow(721, 30, 5, 120, 1, 121, 721),
//18-M
            new ErrorCorrectionTableRow(563, 26, 9, 43, 4, 44, 563),
//18-Q
            new ErrorCorrectionTableRow(397, 28, 17, 22, 1, 23, 397),
//18-H
            new ErrorCorrectionTableRow(313, 28, 2, 14, 19, 15, 313),
//19-L
            new ErrorCorrectionTableRow(795, 28, 3, 113, 4, 114, 795),
//19-M
            new ErrorCorrectionTableRow(627, 26, 3, 44, 11, 45, 627),
//19-Q
            new ErrorCorrectionTableRow(445, 26, 17, 21, 4, 22, 445),
//19-H
            new ErrorCorrectionTableRow(341, 26, 9, 13, 16, 14, 341),
//20-L
            new ErrorCorrectionTableRow(861, 28, 3, 107, 5, 108, 861),
//20-M
            new ErrorCorrectionTableRow(669, 26, 3, 41, 13, 42, 669),
//20-Q
            new ErrorCorrectionTableRow(485, 30, 15, 24, 5, 25, 485),
//20-H
            new ErrorCorrectionTableRow(385, 28, 15, 15, 10, 16, 385),
//21-L
            new ErrorCorrectionTableRow(932, 28, 4, 116, 4, 117, 932),
//21-M
            new ErrorCorrectionTableRow(714, 26, 17, 42, 714),
//21-Q
            new ErrorCorrectionTableRow(512, 28, 17, 22, 6, 23, 512),
//21-H
            new ErrorCorrectionTableRow(406, 30, 19, 16, 6, 17, 406),
//22-L
            new ErrorCorrectionTableRow(1006, 28, 2, 111, 7, 112, 1006),
//22-M
            new ErrorCorrectionTableRow(782, 28, 17, 46, 782),
//22-Q
            new ErrorCorrectionTableRow(568, 30, 7, 24, 16, 25, 568),
//22-H
            new ErrorCorrectionTableRow(442, 24, 34, 13, 442),
//23-L
            new ErrorCorrectionTableRow(1094, 30, 4, 121, 5, 122, 1094),
//23-M
            new ErrorCorrectionTableRow(860, 28, 4, 47, 14, 48, 860),
//23-Q
            new ErrorCorrectionTableRow(614, 30, 11, 24, 14, 25, 614),
//23-H
            new ErrorCorrectionTableRow(464, 30, 16, 15, 14, 16, 464),
//24-L
            new ErrorCorrectionTableRow(1174, 30, 6, 117, 4, 118, 1174),
//24-M
            new ErrorCorrectionTableRow(914, 28, 6, 45, 14, 46, 914),
//24-Q
            new ErrorCorrectionTableRow(664, 30, 11, 24, 16, 25, 664),
//24-H
            new ErrorCorrectionTableRow(514, 30, 30, 16, 2, 17, 514),
//25-L
            new ErrorCorrectionTableRow(1276, 26, 8, 106, 4, 107, 1276),
//25-M
            new ErrorCorrectionTableRow(1000, 28, 8, 47, 13, 48, 1000),
//25-Q
            new ErrorCorrectionTableRow(718, 30, 7, 24, 22, 25, 718),
//25-H
            new ErrorCorrectionTableRow(538, 30, 22, 15, 13, 16, 538),
//26-L
            new ErrorCorrectionTableRow(1370, 28, 10, 114, 2, 115, 1370),
//26-M
            new ErrorCorrectionTableRow(1062, 28, 19, 46, 4, 47, 1062),
//26-Q
            new ErrorCorrectionTableRow(754, 28, 28, 22, 6, 23, 754),
//26-H
            new ErrorCorrectionTableRow(596, 30, 33, 16, 4, 17, 596),
//27-L
            new ErrorCorrectionTableRow(1468, 30, 8, 122, 4, 123, 1468),
//27-M
            new ErrorCorrectionTableRow(1128, 28, 22, 45, 3, 46, 1128),
//27-Q
            new ErrorCorrectionTableRow(808, 30, 8, 23, 26, 24, 808),
//27-H
            new ErrorCorrectionTableRow(628, 30, 12, 15, 28, 16, 628),
//28-L
            new ErrorCorrectionTableRow(1531, 30, 3, 117, 10, 118, 1531),
//28-M
            new ErrorCorrectionTableRow(1193, 28, 3, 45, 23, 46, 1193),
//28-Q
            new ErrorCorrectionTableRow(871, 30, 4, 24, 31, 25, 871),
//28-H
            new ErrorCorrectionTableRow(661, 30, 11, 15, 31, 16, 661),
//29-L
            new ErrorCorrectionTableRow(1631, 30, 7, 116, 7, 117, 1631),
//29-M
            new ErrorCorrectionTableRow(1267, 28, 21, 45, 7, 46, 1267),
//29-Q
            new ErrorCorrectionTableRow(911, 30, 1, 23, 37, 24, 911),
//29-H
            new ErrorCorrectionTableRow(701, 30, 19, 15, 26, 16, 701),
//30-L
            new ErrorCorrectionTableRow(1735, 30, 5, 115, 10, 116, 1735),
//30-M
            new ErrorCorrectionTableRow(1373, 28, 19, 47, 10, 48, 1373),
//30-Q
            new ErrorCorrectionTableRow(985, 30, 15, 24, 25, 25, 985),
//30-H
            new ErrorCorrectionTableRow(745, 30, 23, 15, 25, 16, 745),
//31-L
            new ErrorCorrectionTableRow(1843, 30, 13, 115, 3, 116, 1843),
//31-M
            new ErrorCorrectionTableRow(1455, 28, 2, 46, 29, 47, 1455),
//31-Q
            new ErrorCorrectionTableRow(1033, 30, 42, 24, 1, 25, 1033),
//31-H
            new ErrorCorrectionTableRow(793, 30, 23, 15, 28, 16, 793),
//32-L
            new ErrorCorrectionTableRow(1955, 30, 17, 115, 1955),
//32-M
            new ErrorCorrectionTableRow(1541, 28, 10, 46, 23, 47, 1541),
//32-Q
            new ErrorCorrectionTableRow(1115, 30, 10, 24, 35, 25, 1115),
//32-H
            new ErrorCorrectionTableRow(845, 30, 19, 15, 35, 16, 845),
//33-L
            new ErrorCorrectionTableRow(2071, 30, 17, 115, 1, 116, 2071),
//33-M
            new ErrorCorrectionTableRow(1631, 28, 14, 46, 21, 47, 1631),
//33-Q
            new ErrorCorrectionTableRow(1171, 30, 29, 24, 19, 25, 1171),
//33-H
            new ErrorCorrectionTableRow(901, 30, 11, 15, 46, 16, 901),
//34-L
            new ErrorCorrectionTableRow(2191, 30, 13, 115, 6, 116, 2191),
//34-M
            new ErrorCorrectionTableRow(1725, 28, 14, 46, 23, 47, 1725),
//34-Q
            new ErrorCorrectionTableRow(1231, 30, 44, 24, 7, 25, 1231),
//34-H
            new ErrorCorrectionTableRow(961, 30, 59, 16, 1, 17, 961),
//35-L
            new ErrorCorrectionTableRow(2306, 30, 12, 121, 7, 122, 2306),
//35-M
            new ErrorCorrectionTableRow(1812, 28, 12, 47, 26, 48, 1812),
//35-Q
            new ErrorCorrectionTableRow(1286, 30, 39, 24, 14, 25, 1286),
//35-H
            new ErrorCorrectionTableRow(986, 30, 22, 15, 41, 16, 986),
//36-L
            new ErrorCorrectionTableRow(2434, 30, 6, 121, 14, 122, 2434),
//36-M
            new ErrorCorrectionTableRow(1914, 28, 6, 47, 34, 48, 1914),
//36-Q
            new ErrorCorrectionTableRow(1354, 30, 46, 24, 10, 25, 1354),
//36-H
            new ErrorCorrectionTableRow(1054, 30, 2, 15, 64, 16, 1054),
//37-L
            new ErrorCorrectionTableRow(2566, 30, 17, 122, 4, 123, 2566),
//37-M
            new ErrorCorrectionTableRow(1992, 28, 29, 46, 14, 47, 1992),
//37-Q
            new ErrorCorrectionTableRow(1426, 30, 49, 24, 10, 25, 1426),
//37-H
            new ErrorCorrectionTableRow(1096, 30, 24, 15, 46, 16, 1096),
//38-L
            new ErrorCorrectionTableRow(2702, 30, 4, 122, 18, 123, 2702),
//38-M
            new ErrorCorrectionTableRow(2102, 28, 13, 46, 32, 47, 2102),
//38-Q
            new ErrorCorrectionTableRow(1502, 30, 48, 24, 14, 25, 1502),
//38-H
            new ErrorCorrectionTableRow(1142, 30, 42, 15, 32, 16, 1142),
//39-L
            new ErrorCorrectionTableRow(2812, 30, 20, 117, 4, 118, 2812),
//39-M
            new ErrorCorrectionTableRow(2216, 28, 40, 47, 7, 48, 2216),
//39-Q
            new ErrorCorrectionTableRow(1582, 30, 43, 24, 22, 25, 1582),
//39-H
            new ErrorCorrectionTableRow(1222, 30, 10, 15, 67, 16, 1222),
//40-L
            new ErrorCorrectionTableRow(2956, 30, 19, 118, 6, 119, 2956),
//40-M
            new ErrorCorrectionTableRow(2334, 28, 18, 47, 31, 48, 2334),
//40-Q
            new ErrorCorrectionTableRow(1666, 30, 34, 24, 34, 25, 1666),
//40-H
            new ErrorCorrectionTableRow(1276, 30, 20, 15, 61, 16, 1276)
    };

    public static int byteCapacity(QRVersion qrv) {
        return TABLE_ROWS[(qrv.version() - 1) * 4 + qrv.rankOfEcLevel()].byteCapacity();
    }

    public static DataBlock[] intoBlocks(QRVersion qrv, byte[] raw) {
        ErrorCorrectionTableRow tr = TABLE_ROWS[(qrv.version() - 1) * 4 + qrv.rankOfEcLevel()];
        int ecN = tr.ecCodewordsPerBlock();
        int ptr = 0;
        DataBlock[] out = new DataBlock[tr.numberOfBlocksInGroup1() + tr.numberOfBlocksInGroup2()];
        for (int i = 0; i < tr.numberOfBlocksInGroup1(); i++) {
            out[i] = new DataBlock(1, raw, ptr, tr.numberOfCodewordsInBlock1());
            out[i].generateEc(ecN);
            ptr += tr.numberOfCodewordsInBlock1();
        }
        for (int i = tr.numberOfBlocksInGroup1(); i < out.length; i++) {
            out[i] = new DataBlock(2, raw, ptr, tr.numberOfCodewordsInBlock2());
            out[i].generateEc(ecN);
            ptr += tr.numberOfCodewordsInBlock2();
        }
        return out;
    }
}
