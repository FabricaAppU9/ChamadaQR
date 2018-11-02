package fabricaapp.com.br.chamadaqr.cameraqr.model;

public class QRCode {
    private int qrCodeId;

    private String validacao;

    public void setQrCodeId(int qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    public void setValidacao(String validacao) {
        this.validacao = validacao;
    }

    public int getQrCodeId() {
        return qrCodeId;
    }

    public String getValidacao() {
        return validacao;
    }
}
