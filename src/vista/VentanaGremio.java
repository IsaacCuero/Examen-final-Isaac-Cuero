package vista;

import java.awt.event.ActionListener;

public class VentanaGremio extends javax.swing.JFrame {
    public VentanaGremio() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public String nombre() {
        return campoNombre.getText();
    }

    public String nivel() {
        return campoNivel.getText();
    }

    public String vida() {
        return campoVida.getText();
    }

    public String clase() {
        return (String) selectorClase.getSelectedItem();
    }

    public String rasgo() {
        return campoRasgo.getText();
    }

    public void pedirRasgo(String etiqueta) {
        etiquetaRasgo.setText(etiqueta);
        campoRasgo.setText("");
    }

    public void limpiarRegistro() {
        campoNombre.setText("");
        campoNivel.setText("1");
        campoVida.setText("");
        campoRasgo.setText("");
        campoNombre.requestFocusInWindow();
    }

    public void mostrarGremio(String texto) {
        listaGremio.setText(texto);
        listaGremio.setCaretPosition(0);
    }

    public void mostrarResultado(String texto) {
        resultado.setText(texto);
        resultado.setCaretPosition(0);
    }

    public void alRegistrar(ActionListener accion) {
        botonRegistrar.addActionListener(accion);
    }

    public void alCambiarClase(ActionListener accion) {
        selectorClase.addActionListener(accion);
    }

    public void alSimular(ActionListener accion) {
        botonSimular.addActionListener(accion);
    }

    public void alPedirReportes(ActionListener accion) {
        botonReportes.addActionListener(accion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        selectorClase = new javax.swing.JComboBox<>();
        botonRegistrar = new javax.swing.JButton();
        panelGremio = new javax.swing.JScrollPane();
        listaGremio = new javax.swing.JTextArea();
        panelResultado = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextArea();
        campoNivel = new javax.swing.JTextField();
        campoRasgo = new javax.swing.JTextField();
        botonSimular = new javax.swing.JButton();
        botonReportes = new javax.swing.JButton();
        campoVida = new javax.swing.JTextField();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaClase = new javax.swing.JLabel();
        etiquetaVida = new javax.swing.JLabel();
        etiquetaNivel = new javax.swing.JLabel();
        etiquetaRasgo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Archivo del gremio");

        titulo.setText("Gremio de aventureros");
        titulo.setForeground(new java.awt.Color(36, 66, 74));
        titulo.setFont(new java.awt.Font("Serif", 1, 26)); // NOI18N

        selectorClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Mago", "Clérigo", "Monje" }));

        botonRegistrar.setText("Registrar aventurero");
        botonRegistrar.setBackground(new java.awt.Color(36, 85, 88));
        botonRegistrar.setForeground(new java.awt.Color(255, 255, 255));

        panelGremio.setBorder(javax.swing.BorderFactory.createTitledBorder("Aventureros registrados"));

        listaGremio.setColumns(20);
        listaGremio.setRows(5);
        listaGremio.setEditable(false);
        listaGremio.setLineWrap(true);
        listaGremio.setWrapStyleWord(true);
        panelGremio.setViewportView(listaGremio);

        panelResultado.setBorder(javax.swing.BorderFactory.createTitledBorder("Combate y reportes"));

        resultado.setColumns(20);
        resultado.setRows(5);
        resultado.setEditable(false);
        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);
        panelResultado.setViewportView(resultado);

        campoNivel.setText("1");

        botonSimular.setText("Simular combate");

        botonReportes.setText("Ver reportes");

        etiquetaNombre.setText("Nombre");

        etiquetaClase.setText("Clase");

        etiquetaVida.setText("Puntos de vida");

        etiquetaNivel.setText("Nivel");

        etiquetaRasgo.setText("Armadura pesada (sí/no)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaNombre)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 228, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaClase)
                            .addComponent(selectorClase, javax.swing.GroupLayout.PREFERRED_SIZE, 144, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaNivel)
                            .addComponent(campoNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaVida)
                            .addComponent(campoVida, javax.swing.GroupLayout.PREFERRED_SIZE, 104, Short.MAX_VALUE)))
                    .addComponent(etiquetaRasgo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoRasgo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addComponent(botonRegistrar))
                    .addComponent(panelGremio, javax.swing.GroupLayout.PREFERRED_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonSimular)
                        .addGap(14, 14, 14)
                        .addComponent(botonReportes))
                    .addComponent(panelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 620, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titulo)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(etiquetaClase)
                    .addComponent(etiquetaNivel)
                    .addComponent(etiquetaVida))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectorClase, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoVida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(etiquetaRasgo)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoRasgo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(panelGremio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(panelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 156, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonReportes;
    private javax.swing.JButton botonSimular;
    private javax.swing.JTextField campoNivel;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoRasgo;
    private javax.swing.JTextField campoVida;
    private javax.swing.JLabel etiquetaClase;
    private javax.swing.JLabel etiquetaNivel;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaRasgo;
    private javax.swing.JLabel etiquetaVida;
    private javax.swing.JTextArea listaGremio;
    private javax.swing.JScrollPane panelGremio;
    private javax.swing.JScrollPane panelResultado;
    private javax.swing.JTextArea resultado;
    private javax.swing.JComboBox<String> selectorClase;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
