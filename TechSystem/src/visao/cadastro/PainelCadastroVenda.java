package visao.cadastro;

import com.alee.laf.combobox.WebComboBox;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.tabbedpane.WebTabbedPane;
import com.alee.laf.table.WebTable;
import com.alee.laf.text.WebFormattedTextField;
import com.alee.laf.text.WebTextField;
import controle.evento.BtCadastrarVenda;
import controle.evento.MouseCadastrarVendaCpfCliente;
import controle.evento.MouseCadastrarVendaCpfFuncionario;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;
import visao.PainelSistema;

/**
 * Painel para cadastro de venda
 *
 * @author Pedro Celestino Silveira Junior
 */
public class PainelCadastroVenda extends PainelSistema {

    private static final long serialVersionUID = 1L;
    private BtCadastrarVenda acaoBtCadastrarVenda;
    private MouseCadastrarVendaCpfCliente acaoMouseCadastrarVendaCpfCliente;
    private MouseCadastrarVendaCpfFuncionario acaoMouseCadastrarVendaCpfFuncionario;
    private GridBagConstraints restricoes;
    private TitledBorder bordaTitulo;
    private WebTabbedPane painelAbas;
    private WebTextField tfNomeVenda;
    private WebFormattedTextField ftfValorVenda;
    private WebTable tabelaVenda, tabelaCliente, tabelaFuncionario;
    private WebComboBox cbCpfCliente, cbCpfFuncionario;
    private WebScrollPane spVenda;
    private ArrayList<Object> obj;

    /**
     * Carrega os componentes do painel
     */
    public void carregarComponentes() {

        acaoBtCadastrarVenda = new BtCadastrarVenda();
        acaoMouseCadastrarVendaCpfCliente = new MouseCadastrarVendaCpfCliente();
        acaoMouseCadastrarVendaCpfFuncionario = new MouseCadastrarVendaCpfFuncionario();
        restricoes = new GridBagConstraints();
        cbCpfCliente = super.getCbCpfCliente();
        cbCpfFuncionario = super.getCbCpfFuncionario();
        tfNomeVenda = super.getTfNomeVenda();
        ftfValorVenda = super.getFtfValorVenda();

        // Edição do título do painel
        bordaTitulo = new TitledBorder("Cadastro de Vendas");
        bordaTitulo.setTitleJustification(TitledBorder.CENTER);
        super.setBorder(bordaTitulo);

        restricoes.insets = new Insets(20, 20, 20, 20);

        restricoes.anchor = GridBagConstraints.WEST;
        restricoes.gridy = 0;
        restricoes.gridx = 0;
        this.add(super.getLbSistema("Cliente: "), restricoes);

        restricoes.gridy = 1;
        restricoes.gridx = 0;
        this.add(super.getLbSistema("Funcionario: "), restricoes);

        restricoes.gridy = 2;
        restricoes.gridx = 0;
        this.add(super.getLbSistema("Venda: "), restricoes);

        restricoes.gridy = 3;
        restricoes.gridx = 0;
        this.add(super.getLbSistema("Valor: "), restricoes);

        restricoes.weighty = 1;
        restricoes.gridy = 0;
        restricoes.gridx = 1;
        this.add(cbCpfCliente, restricoes);

        restricoes.gridy = 1;
        restricoes.gridx = 1;
        this.add(cbCpfFuncionario, restricoes);

        restricoes.gridy = 2;
        restricoes.gridx = 1;
        this.add(tfNomeVenda, restricoes);

        restricoes.gridy = 3;
        restricoes.gridx = 1;
        this.add(ftfValorVenda, restricoes);

        restricoes.gridy = 4;
        restricoes.gridx = 1;
        this.add(super.getBtCadastrar(), restricoes);

        restricoes.gridy = 0;
        restricoes.gridx = 3;
        restricoes.weightx = 1;
        restricoes.gridheight = GridBagConstraints.REMAINDER;
        restricoes.fill = GridBagConstraints.BOTH;

        painelAbas = new WebTabbedPane();
        painelAbas.setRound(3);
        painelAbas.setFontSize(14);
        painelAbas.setPreferredSize(new Dimension(200, 100));
        painelAbas.setTabPlacement(WebTabbedPane.TOP);
        painelAbas.setFocusable(false);

        tabelaVenda = super.gerarTabelaVenda();
        spVenda = super.getSpPessoas();
        painelAbas.addTab("Vendas", spVenda);

        tabelaCliente = super.gerarTabelaCliente();
        spVenda = super.getSpPessoas();
        painelAbas.addTab("Clientes", spVenda);

        tabelaFuncionario = super.gerarTabelaFuncionario();
        spVenda = super.getSpPessoas();
        painelAbas.addTab("Funcionarios", spVenda);

        this.add(painelAbas, restricoes);
        
        tabelaCliente.addMouseListener(acaoMouseCadastrarVendaCpfCliente);
        tabelaFuncionario.addMouseListener(acaoMouseCadastrarVendaCpfFuncionario);
        super.setBtCadastrar("btCadastrarVenda", acaoBtCadastrarVenda);

        this.revalidate();
    }

    /**
     * Atualiza a tabela de venda
     */
    public void fireTabelaVenda() {

        painelAbas.removeAll();

        tabelaVenda = super.gerarTabelaVenda();
        spVenda = super.getSpPessoas();
        painelAbas.addTab("Vendas", spVenda);

        tabelaCliente = super.gerarTabelaCliente();
        spVenda = super.getSpPessoas();
        painelAbas.addTab("Clientes", spVenda);

        tabelaFuncionario = super.gerarTabelaFuncionario();
        spVenda = super.getSpPessoas();
        painelAbas.addTab("Funcionarios", spVenda);

        this.add(painelAbas, restricoes);
        tabelaCliente.addMouseListener(acaoMouseCadastrarVendaCpfCliente);
        tabelaFuncionario.addMouseListener(acaoMouseCadastrarVendaCpfFuncionario);
        this.revalidate();
    }

    /**
     * Atualiza ComboBox de venda
     */
    public void fireCbVenda() {

        cbCpfCliente = super.atualizaCbCpfCliente();
        cbCpfFuncionario = super.atualizaCbCpfFuncionario();
        this.repaint();
    }

    /**
     * Retorna uma tabela de venda
     *
     * @return uma tabela de venda
     */
    public WebTable getTabelaVenda() {
        return tabelaVenda;
    }

    /**
     * Retorna uma tabela de cliente
     *
     * @return uma tabela de cliente
     */
    public WebTable getTabelaCliente() {
        return tabelaCliente;
    }

    /**
     * Retorna uma tabela de funcionário
     *
     * @return uma tabela de funcionário
     */
    public WebTable getTabelaFuncionario() {
        return tabelaFuncionario;
    }

    /**
     * Retorna um ComboBox para o cpf do cliente
     *
     * @return um ComboBox para o cpf do cliente
     */
    @Override
    public WebComboBox getCbCpfCliente() {
        return cbCpfCliente;
    }

    /**
     * Retorna um ComboBox para o cpf do funcionário
     *
     * @return um ComboBox para o cpf do funcionário
     */
    @Override
    public WebComboBox getCbCpfFuncionario() {
        return cbCpfFuncionario;
    }

    /**
     * Retorna um TextField para o nome da venda
     *
     * @return um TextField para o nome da venda
     */
    @Override
    public WebTextField getTfNomeVenda() {
        return tfNomeVenda;
    }

    /**
     * Retorna um TextField para o valor da venda
     *
     * @return um TextField para o valor da venda
     */
    @Override
    public WebFormattedTextField getFtfValorVenda() {
        return ftfValorVenda;
    }
    
    /**
     * Retorna a linha selecionada na tabela de cliente
     *
     * @return a linha selecionada na tabela de cliente
     */
    public int getLinhaSelecionadaTbCliente() {
        return this.getTabelaCliente().getSelectedRow();
    }
    
    /**
     * Retorna um Object contendo os valores de uma linha da tabela de cliente
     *
     * @param linhaSelecionada a linha selecionada na tabela de cliente
     * @return um Object contendo os valores de uma linha da tabela de cliente
     */
    public ArrayList<Object> getValoresEmTbCliente(int linhaSelecionada) {

        int qtColunas = this.getTabelaCliente().getColumnCount();
        obj = new ArrayList<>();

        for (int i = 0; i < qtColunas; i++) {
            obj.add(this.getTabelaCliente().getValueAt(linhaSelecionada, i));
        }

        return obj;
    }
    
    /**
     * Retorna a linha selecionada na tabela de funcionário
     *
     * @return a linha selecionada na tabela de funcionário
     */
    public int getLinhaSelecionadaTbFuncionario() {
        return this.getTabelaFuncionario().getSelectedRow();
    }
    
    /**
     * Retorna um Object contendo os valores de uma linha da tabela de funcionário
     *
     * @param linhaSelecionada a linha selecionada na tabela de cliente
     * @return um Object contendo os valores de uma linha da tabela de funcionário
     */
    public ArrayList<Object> getValoresEmTbFuncionario(int linhaSelecionada) {

        int qtColunas = this.getTabelaFuncionario().getColumnCount();
        obj = new ArrayList<>();

        for (int i = 0; i < qtColunas; i++) {
            obj.add(this.getTabelaFuncionario().getValueAt(linhaSelecionada, i));
        }

        return obj;
    }

    /**
     * Limpa os dados dos componentes
     */
    public void limpaComponentes() {

        this.getCbCpfCliente().setSelectedItem(null);
        this.getCbCpfFuncionario().setSelectedItem(null);
        this.getTfNomeVenda().setText(null);
        this.getFtfValorVenda().setText(null);
    }

}
