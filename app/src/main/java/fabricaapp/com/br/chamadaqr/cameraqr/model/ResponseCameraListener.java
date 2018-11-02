package fabricaapp.com.br.chamadaqr.cameraqr.model;

public interface ResponseCameraListener {
     void getQRCode(QRCode qrCode);
     void getDate(Date date);
     void isFrequencySuccess(Boolean isSuccess);
}
