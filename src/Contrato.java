import java.time.LocalDate;

public class Contrato implements Calculos {
    private Locador locador;
    private Inquilino inquilino;
    private Imovel imovel;
    private double valorAluguel;
    private LocalDate dataContrato;

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public LocalDate getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato() {
        this.dataContrato = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Contrato:" + "\n" +
                "  Locador: " + locador.getNome() + "\n" +
                "  CPF do Locador: " + locador.getCpf() + "\n" +
                "  Inquilino: " + inquilino.getNome() + "\n" +
                "  CPF do Inquilino: " + inquilino.getCpf() + "\n" +
                "  Imovel: " + imovel.getTipoImovel() + "\n" +
                "  Valor do Aluguel: " + valorAluguel + "\n" +
                "  Data de Assinatura: " + dataContrato ;
    }

    @Override
    public double multaAtraso() {
        return valorAluguel * 0.05;
    }

    @Override
    public void corrigirInflacao(double aliquota) {
        this.valorAluguel += this.valorAluguel * aliquota;
    }
}
