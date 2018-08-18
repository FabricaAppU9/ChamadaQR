package br.com.fabricaapp.chamadaqr.domain;

    public class Professor {
        private int idProfessor;
        private String nome;
        private int matricula;

        public int getIdProfessor() {
            return idProfessor;
        }

        public void setIdProfessor(int idProfessor) {
            this.idProfessor = idProfessor;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getMatricula() {
            return matricula;
        }

        public void setMatricula(int matricula) {
            this.matricula = matricula;
        }
    }
