package fabricaapp.com.br.chamadaqr.login.model;



public class User {
    private final int alunoId;

    private final long matricula;

    private final String alunoNome;

    private final String status;

    public User(int alunoId, long matricula, String alunoNome, String status) {
        this.alunoId = alunoId;
        this.matricula = matricula;
        this.alunoNome = alunoNome;
        this.status = status;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public long getMatricula() {
        return matricula;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public String getStatus() {
        return status;
    }
}
