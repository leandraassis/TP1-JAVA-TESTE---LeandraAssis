package br.edu.infnet.leandraassis.model.domain;

public class Cliente {

	private String nome;
	private double saldo;
	private double divida;
	private boolean vip;
	
	public double calcularDivida() {
		return vip ? divida - (divida*0.1) : divida;
	}
	
	public double calcularSaldo() {
		return saldo - calcularDivida();
	}
	
	//método a ser aprimorado
	public String verificacaoSaldo() {
		if(calcularSaldo() < 0) {
			return "Erro ao efetuar o pagamento";
		}
		return "Pagamento efetuado";
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getDivida() {
		return divida;
	}

	public void setDivida(double divida) {
		this.divida = divida;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
}
