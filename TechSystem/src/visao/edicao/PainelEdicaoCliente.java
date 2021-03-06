package visao.edicao;

import com.alee.laf.button.WebButton;
import com.alee.laf.combobox.WebComboBox;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.WebTable;
import com.alee.laf.text.WebFormattedTextField;
import com.alee.laf.text.WebTextField;
import controle.evento.BtAtualizarCliente;
import controle.evento.BtExcluirCliente;
import controle.evento.MouseEditarCliente;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;
import visao.PainelSistema;

/**
 * Painel para edição de cliente
 *
 * @author Pedro Celestino Silveira Junior
 */
public class PainelEdicaoCliente extends PainelSistema {

    private static final long serialVersionUID = 1L;

    private BtAtualizarCliente acaoBtAtualizarCliente;
    private BtExcluirCliente acaoBtExcluirCliente;
    private MouseEditarCliente acaoMouseEditarCliente;

    private GridBagConstraints restricoes;
    private TitledBorder bordaTitulo;
    private WebTextField tfNome;
    private WebFormattedTextField ftfCpf, ftfDataNascimento;
    private WebComboBox cbTipo;
    private WebButton btAtualizar, btExcluir;
    private WebScrollPane spCliente;
    private WebTable tabelaCliente;
    private ArrayList<Object> obj;
    private Object ob;

    /**
     * Carrega os componentes do painel
     */
    public void carregarComponentes() {

        acaoBtAtualizarCliente = new BtAtualizarCliente();
        acaoBtExcluirCliente = new BtExcluirCliente();
        acaoMouseEditarCliente = new MouseEditarCliente();

        restricoes = new GridBagConstraints();
        tabelaCliente = super.gerarTabelaCliente();
        tfNome = super.getTfNome();
        ftfCpf = super.getFtfCpf();
        ftfDataNascimento = super.getFtfDataNascimento();
        cbTipo = super.getCbTipo();
        btAtualizar = super.getBtAtualizar();
        btExcluir = super.getBtExcluir();
        spCliente = super.getSpPessoas();

        // Edição do título do painel
        bordaTitulo = new TitledBorder("Edição de Clientes");
        bordaTitulo.setTitleJustification(TitledBorder.CENTER);
        super.setBorder(bordaTitulo);

        restricoes.insets = new Insets(20, 20, 20, 20);

        restricoes.anchor = GridBagConstraints.WEST;
        restricoes.gridy = 0;
        restricoes.gridx = 0;
        this.add(super.getLbSistema("Nome: "), restricoes);

        restricoes.gridy = 1;
        restricoes.gridx = 0;
        this.add(super.getLbSistema("CPF: "), restricoes);

        restricoes.gridy = 2;
        restricoes.gridx = 0;
        this.add(super.getLbSistema("Nascimento: "), restricoes);

        restricoes.gridy = 3;
        restricoes.gridx = 0;
        this.add(super.getLbSistema("Tipo: "), restricoes);

        restricoes.weighty = 1;
        restricoes.gridy = 0;
        restricoes.gridx = 1;
        this.add(tfNome, restricoes);

        restricoes.gridy = 1;
        restricoes.gridx = 1;
        this.add(ftfCpf, restricoes);

        restricoes.gridy = 2;
        restricoes.gridx = 1;
        this.add(ftfDataNascimento, restricoes);

        restricoes.gridy = 3;
        restricoes.gridx = 1;
        this.add(cbTipo, restricoes);

        restricoes.gridy = 4;
        restricoes.gridx = 1;
        this.add(btAtualizar, restricoes);

        restricoes.gridy = 4;
        restricoes.gridx = 0;
        this.add(btExcluir, restricoes);

        restricoes.gridy = 0;
        restricoes.gridx = 3;
        restricoes.weightx = 1;
        restricoes.gridheight = GridBagConstraints.REMAINDER;
        restricoes.fill = GridBagConstraints.BOTH;
        this.add(spCliente, restricoes);

        tabelaCliente.addMouseListener(acaoMouseEditarCliente);
        super.setBtAtualizar("btAtualizarCliente", acaoBtAtualizarCliente);
        super.setBtExcluir("btExcluirCliente", acaoBtExcluirCliente);

        this.revalidate();
    }

    /**
     * Atualiza a tabela de cliente
     */
    public void fireTabelaCliente() {

        tabelaCliente = super.atualizarTabelaCliente();
        this.repaint();
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
     * Retorna um TextField para o nome do cliente
     *
     * @return um TextField para o nome do cliente
     */
    @Override
    public WebTextField getTfNome() {
        return tfNome;
    }

    /**
     * Retorna um TextField para o cpf do cliente
     *
     * @return um TextField para o cpf do cliente
     */
    @Override
    public WebFormattedTextField getFtfCpf() {
        return ftfCpf;
    }

    /**
     * Retorna um TextField para a data de nascimento do cliente
     *
     * @return um TextField para a data de nascimento do cliente
     */
    @Override
    public WebFormattedTextField getFtfDataNascimento() {
        return ftfDataNascimento;
    }

    /**
     * Retorna um ComboBox para o tipo do cliente
     *
     * @return um ComboBox para o tipo do cliente
     */
    @Override
    public WebComboBox getCbTipo() {
        return cbTipo;
    }

    /**
     * Retorna um Button para atualização do cliente
     *
     * @return um Button para atualização do cliente
     */
    @Override
    public WebButton getBtAtualizar() {

        return btAtualizar;
    }

    /**
     * Retorna um Button para exclusão do cliente
     *
     * @return um Button para exclusão do cliente
     */
    @Override
    public WebButton getBtExcluir() {

        return btExcluir;
    }

    /**
     * Retorna a linha selecionada na tabela de cliente
     *
     * @return a linha selecionada na tabela de cliente
     */
    public int getLinhaSelecionada() {
        return this.getTabelaCliente().getSelectedRow();
    }

    /**
     * Retorna uma String de uma tabela de acordo com os parametros linha e
     * coluna
     *
     * @param linha a linha da tabela de cliente
     * @param coluna a coluna da tabela de cliente
     * @return uma String de uma tabela de acordo com os parametros linha e
     * coluna
     */
    public String getTextoEm(int linha, int coluna) {

        ob = this.getTabelaCliente().getValueAt(linha, coluna);

        return ob.toString();
    }

    /**
     * Retorna um Object contendo os valores de uma linha da tabela de cliente
     *
     * @param linhaSelecionada a linha selecionada na tabela de cliente
     * @return um Object contendo os valores de uma linha da tabela de cliente
     */
    public ArrayList<Object> getValoresEm(int linhaSelecionada) {

        int qtColunas = this.getTabelaCliente().getColumnCount();
        obj = new ArrayList<>();

        for (int i = 0; i < qtColunas; i++) {
            obj.add(this.getTabelaCliente().getValueAt(linhaSelecionada, i));
        }

        return obj;
    }

    /**
     * Habilita os componentes do painel
     */
    public void habilitaComponentes() {

        this.getTfNome().setEnabled(true);
        this.getFtfCpf().setEnabled(true);
        this.getFtfDataNascimento().setEnabled(true);
        this.getCbTipo().setEnabled(true);
        this.getBtAtualizar().setEnabled(true);
        this.getBtExcluir().setEnabled(true);
    }

    /**
     * Desabilita os componentes do painel
     */
    public void desabilitaComponentes() {

        this.getTfNome().setEnabled(false);
        this.getFtfCpf().setEnabled(false);
        this.getFtfDataNascimento().setEnabled(false);
        this.getCbTipo().setEnabled(false);
        this.getBtAtualizar().setEnabled(false);
        this.getBtExcluir().setEnabled(false);
    }

    /**
     * Limpa os dados dos componentes
     */
    public void limpaComponentes() {

        this.getTfNome().setText(null);
        this.getFtfCpf().setText(null);
        this.getFtfDataNascimento().setText(null);
        this.getCbTipo().setSelectedItem(null);
    }

}
