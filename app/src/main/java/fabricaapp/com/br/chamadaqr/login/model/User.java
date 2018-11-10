package fabricaapp.com.br.chamadaqr.login.model;



public class User {
    private int alunoID;

    private long matricula;

    private String alunoNome;

    private String status;

    public int getAlunoId() {
        return alunoID;
    }

    public void setAlunoId(int alunoId) {
        this.alunoID = alunoId;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
