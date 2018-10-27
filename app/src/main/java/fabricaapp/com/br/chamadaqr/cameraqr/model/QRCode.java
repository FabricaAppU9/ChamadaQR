package fabricaapp.com.br.chamadaqr.cameraqr.model;

public class QRCode {
    private final int qrCodeId;

    private final String validacao;

    public QRCode(int qrCodeId, String validacao) {
        this.qrCodeId = qrCodeId;
        this.validacao = validacao;
    }

    public int getQrCodeId() {
        return qrCodeId;
    }

    public String getValidacao() {
        return validacao;
    }
}
