package hiro;

public enum ErrorCorrectionLevel {

    L, M, Q, R;

    public float correctionPercent() {
        switch (this) {
            default:
                return 0.00f;
            case L:
                return 0.07f;
            case M:
                return 0.15f;
            case Q:
                return 0.25f;
            case R:
                return 0.35f;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            default:
                return "Unknown";
            case L:
                return "Low";
            case M:
                return "Medium";
            case Q:
                return "Quartile";
            case R:
                return "High";
        }
    }
}
