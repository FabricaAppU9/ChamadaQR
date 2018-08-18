package br.com.fabricaapp.chamadaqr.domain;

    public class Aluno {
        private int idAluno;
        private String nome;
        private String sobrenome;
        private int semestre;
        private int qsc;
        private String campus;

        public int getIdAluno() {
            return idAluno;
        }

        public void setIdAluno(int idAluno) {
            this.idAluno = idAluno;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        public int getSemestre() {
            return semestre;
        }

        public void setSemestre(int semestre) {
            this.semestre = semestre;
        }

        public int getQsc() {
            return qsc;
        }

        public void setQsc(int qsc) {
            this.qsc = qsc;
        }

        public String getCampus() {
            return campus;
        }

        public void setCampus(String campus) {
            this.campus = campus;
        }
    }
