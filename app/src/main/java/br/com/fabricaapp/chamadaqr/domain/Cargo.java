package br.com.fabricaapp.chamadaqr.domain;

    public class Cargo {
        private int idCargo;
        private String area;
        private String estagio;
        private String celula;

        public int getIdCargo() {
            return idCargo;
        }

        public void setIdCargo(int idCargo) {
            this.idCargo = idCargo;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getEstagio() {
            return estagio;
        }

        public void setEstagio(String estagio) {
            this.estagio = estagio;
        }

        public String getCelula() {
            return celula;
        }

        public void setCelula(String celula) {
            this.celula = celula;
        }
    }
