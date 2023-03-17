package org.example;

//Abtração, a classe componentesgerais é uma classe abstrata e seus métodos serão herdados pelas classes filhas
 abstract class componentesGerais {
    private String CPU;
    private String memoria;
    private String monitor;
    private String teclado;
    private String gabinete;
    private String computador;
    private  double precoTotal;

    //Encapsulamento, os métodos Get e Set abaixo são exemplo de emcapsulamento como forma de fornecer acesso
// seguro aos atributos privados
    public String getCPU() {
        return CPU;
    }
    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getTeclado() {
        return teclado;
    }

    public void setTeclado(String teclado) {
        this.teclado = teclado;
    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }

    public String getComputador() {
        return computador;
    }

    public void setComputador(String computador) {
        this.computador = computador;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}

  //Herança!!! As classes a seguir são exemplos de herança, onde as classes herdam
  //os atributos e métodos da classe mãe
  class Processador extends componentesGerais{
     public double PrecoCPU;
     public String NomeCPU;
      public Processador(String descricao, double preco) {
          setCPU(descricao);
          this.PrecoCPU = preco;
          this.NomeCPU = getCPU();
      }
      public Processador() {

      }
  }

    class Placa extends Processador{
        String NomePlaca;
        int CapacidadePlaca;
        double PrecoPlaca;
        public Placa(String descricao, int capacidade, double preco) {
            setMemoria(descricao);
            this.PrecoPlaca = preco;
            this.CapacidadePlaca = capacidade;
            this.NomePlaca = getMemoria();

        }

        public Placa() {

        }
    }

    class Monitor extends Placa {
        public double PrecoMonitor;
        public double Resolucaomonitor;
        public Monitor(String descricao, double resolucao, double preco) {
            setMonitor(descricao);
            this.PrecoMonitor = preco;
            this.Resolucaomonitor = resolucao;
        }

        public Monitor() {

        }
    }

     class Teclado extends Monitor{
        public double PrecoTeclado;
        public Teclado(String descricao, double preco) {
            setTeclado(descricao);
            this.PrecoTeclado = preco;
        }

         public Teclado() {

         }
     }

     class Gabinete extends Teclado {
        String NomeProcessador;
        String NomeMemoria;
        double PrecoProcessador;
        double PrecoMemoria;
        int Capacidadememoria;

         public Gabinete(String descricao) {
             setGabinete(descricao);

         }
         public Gabinete() {

         }

        //Exemplo de Polimorfismo Estático ou Sobrecarga,
        // o método inclui é implementado diversas vezes recebendo argumentos diferentes
         public void inclui(Processador processador) {
             this.PrecoProcessador = processador.PrecoCPU;
             this.NomeProcessador = processador.NomeCPU;
         }

         public  void inclui(Placa placa){
             this.NomeMemoria = placa.NomePlaca;
             this.Capacidadememoria = placa.CapacidadePlaca;
             this.PrecoMemoria = placa.PrecoPlaca;

         }
     }
//Classe computador recebe como parametros os objetos gabinete, teclado e monitor
//esta classe faz um compilado dos objetos recebidos como parametro e retorna as descrições
//e atributos desses objetos
     class Computador extends Gabinete{
        String nomeGabinete;
        String nomeMonitor;
        double resolucaoMonitor;
        double precomonitor;
        String nomeTeclado;
        double precoTeclado;
        String nomeprocessador;
        double precoprocessador;
        int capacidadeMemoria;
        double precoMemoria;
        String nomeMemoria;

         public Computador(String descricaoPC) {
             setComputador(descricaoPC);
         }

         public void inclui(Gabinete componenteGab) {
            this.nomeGabinete = componenteGab.getGabinete();
            this.nomeprocessador = componenteGab.NomeProcessador;
            this.precoprocessador = componenteGab.PrecoProcessador;
            setPrecoTotal(getPrecoTotal() + this.precoprocessador);

            this.precoMemoria = componenteGab.PrecoMemoria;
            this.nomeMemoria = componenteGab.NomeMemoria;
            this.capacidadeMemoria = componenteGab.Capacidadememoria;
             setPrecoTotal(getPrecoTotal() + this.precoMemoria);
         }

         public void inclui(Teclado componenteTec) {
            this.nomeTeclado = componenteTec.getTeclado();
            this.precoTeclado = componenteTec.PrecoTeclado;
            setPrecoTotal(getPrecoTotal() + this.precoTeclado);

         }
         public void inclui(Monitor componenteMoni) {
            this.nomeMonitor = componenteMoni.getMonitor();
            this.precomonitor = componenteMoni.PrecoMonitor;
            this.resolucaoMonitor = componenteMoni.Resolucaomonitor;
            setPrecoTotal(getPrecoTotal() + this.precomonitor);

         }


    //Classe para imprimir os atributos dos objetos passados como parametro para o Computador
        //Foi feito desta maneira pois não consegui implementar igual ao exemplo passado no enunciado da AD
         public void imprimiPC(){
             System.out.println("***********************************************************************");
             System.out.println("Descrição do computador: " + getComputador());
             System.out.println("gabinete: " + this.nomeGabinete);
             System.out.println("monitor: " + this.nomeMonitor  + ", resolução: " + this.resolucaoMonitor+ ", preço: R$ "+ this.precomonitor);
             System.out.println("teclado: " + this.nomeTeclado + ", preço: R$ " + this.precoTeclado);
             System.out.println("processador: " + this.nomeprocessador + ", preço: R$ " + this.precoprocessador);
             System.out.println("memoria: " + this.nomeMemoria + " ,capacidade: " + capacidadeMemoria+"GB" + ", preço: R$ "+ this.precoMemoria);
             System.out.println("valor total do computador: R$ " + getPrecoTotal());

         }


}

