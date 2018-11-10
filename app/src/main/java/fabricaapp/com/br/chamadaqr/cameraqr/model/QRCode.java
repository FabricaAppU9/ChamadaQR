package fabricaapp.com.br.chamadaqr.cameraqr.model;

public class QRCode {
    private int qrCodeID;

    private String validacao;

    public int getQrCodeId() {
        return qrCodeID;
    }

    public void setValidacao(String validacao) {
        this.validacao = validacao;
    }

    public void setQrCodeId(int qrCodeId) {
        this.qrCodeID = qrCodeId;
    }

    public String getValidacao() {
        return validacao;
    }
}
