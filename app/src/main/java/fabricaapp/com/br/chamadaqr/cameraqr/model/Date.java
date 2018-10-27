package fabricaapp.com.br.chamadaqr.cameraqr.model;

public class Date {
    private final int dataId;

    private final String dataNome;

    public Date(int dataId, String dataNome) {
        this.dataId = dataId;
        this.dataNome = dataNome;
    }

    public int getDataId() {
        return dataId;
    }

    public String getDataNome() {
        return dataNome;
    }
}
