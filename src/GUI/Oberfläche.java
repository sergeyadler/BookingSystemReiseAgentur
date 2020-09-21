package GUI;

import Objekte.Kunde;
import Objekte.Reiseagentur;
import Objekte.Reservierungen;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Oberfläche.
 */
public class Oberfläche extends JFrame{

    private JPanel haupfenster;

    private final Reiseagentur rg;

    private JList<Kunde> kundeJList = new JList<>(new Kunde [] {});

    private JLabel anzahlGefundeneKunden = new JLabel("Kunden gefunden (0)");

    private Kunde selectedCustomer;
    private JList<Reservierungen> listeReservierungen = new JList<>();
    private JLabel kundenNummer;
    private JLabel geburtsDatum;
    private JLabel adresse;


    /**
     * Instantiates a new Oberfläche.
     *
     * @param rg the rg
     */
    public Oberfläche(Reiseagentur rg) {
        super();
        this.rg = rg;
        setTitle(rg.getName());
        this.setSize(800,500);
        this.setLocation(500,500);
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(init_hauptFenster());


    }

    /**
     * Init haupt fenster j panel.
     *
     * @return the j panel
     */
    public JPanel init_hauptFenster(){
        haupfenster = new JPanel();

        haupfenster.setLayout(new BorderLayout());

        haupfenster.add(init_menuBar(), BorderLayout.NORTH);
        haupfenster.add(init_unteresHauptfenster(), BorderLayout.CENTER);

        return haupfenster;
    }

    /**
     * initiates new unteresHauptfenster
     *
     * @return JPanel fenster
     */

    private JPanel init_unteresHauptfenster() {
        JPanel fenster = new JPanel();
        fenster.setLayout(new BorderLayout());
        fenster.add(init_obererBereich(), BorderLayout.NORTH);
        fenster.add(init_untererBereich(), BorderLayout.SOUTH);
        return fenster;
    }

    /**
     * initiates new obererBereich
     *
     * @return JPanel panel
     */

    private JPanel init_obererBereich() {
        JPanel panel = new JPanel();

        // Name
        JLabel rgName = new JLabel(rg.getName(), SwingConstants.CENTER);
        Font font = new Font("Courier", Font.BOLD,18);
        rgName.setFont(font);

        JPanel unteresPanel = new JPanel();
        unteresPanel.setLayout(new FlowLayout());


        BorderLayout borderLayout = new BorderLayout();
        panel.setLayout(borderLayout);
        panel.add(rgName, BorderLayout.NORTH);

        // Kundenname Panel
        JLabel kundenName = new JLabel();
        kundenName.setText("Kundenname");
        unteresPanel.add(kundenName);

        // Suchfeld
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200,20));
        unteresPanel.add(searchField);





        // Suchen Button
        JButton suchen = new JButton("Suchen");
        unteresPanel.add(suchen);
        suchen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kundeJList.removeAll();
                ArrayList<Kunde> gefundeneKunden = rg.findCustomers(searchField.getText());
                Kunde kunden [] = gefundeneKunden.toArray(new Kunde[] {});
                anzahlGefundeneKunden.setText("Kunden gefunden (" + kunden.length+ ")");
                kundeJList.setListData(kunden);

            }
        });

        kundeJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (kundeJList.getValueIsAdjusting() == true) {
                    // System.out.println(kundeJList.getSelectedValue().toString() + " haha");
                    listeReservierungen.removeAll();
                    Kunde kunde = kundeJList.getSelectedValue();
                    Reservierungen reservierungen [] = kunde.getReservierungen().toArray(new Reservierungen[] {});
                    kundenNummer.setText(kunde.getKundenNummer());
                    geburtsDatum.setText(kunde.getGeburtsDatum().toString());
                    adresse.setText(kunde.getAdresse().toString());
                    /*for (Reservierungen rs: reservierungen)
                        System.out.println(rs.toString());*/
                    listeReservierungen.setListData(reservierungen);
                }
            }
        });

        panel.setBorder(new LineBorder(Color.WHITE));
        panel.add(unteresPanel, BorderLayout.CENTER);
        return panel;
    }

    /**
     * initiates new unterer Bereich
     *
     * @return JPanel fenster
     */

    private JPanel init_untererBereich() {
        JPanel fenster = new JPanel();
        fenster.setLayout(new FlowLayout());
        fenster.add(init_untenLinks());
        fenster.add(init_untenRechts());
        return fenster;
    }

    /**
     * initiates new Panel untenRechts
     *
     * @return JPanel fenster
     */

    private JPanel init_untenRechts() {
        JPanel fenster = new JPanel();
        fenster.setLayout(new BorderLayout());

        //oben
        JPanel oberesFenster = new JPanel();
        kundenNummer = new JLabel();
        geburtsDatum = new JLabel();
        adresse = new JLabel();
        oberesFenster.setLayout(new GridLayout(3,2));
        oberesFenster.add(new JLabel("Kundennummer:"));
        oberesFenster.add(kundenNummer);

        oberesFenster.add(new JLabel("Geburtsdatum:"));
        oberesFenster.add(geburtsDatum);

        oberesFenster.add(new JLabel("Adresse:"));
        oberesFenster.add(adresse);

        // unten
        JScrollPane JlisteReservierungen = new JScrollPane(listeReservierungen);

        JlisteReservierungen.setPreferredSize(new Dimension(300,300));


        fenster.add(oberesFenster, BorderLayout.NORTH);
        fenster.add(JlisteReservierungen, BorderLayout.SOUTH);
        return fenster;
    }

    /**
     * initiates new Panel untenLinks
     *
     * @return JPanel fenster
     */

    private JPanel init_untenLinks() {

        JPanel links = new JPanel();
        links.setLayout(new BorderLayout());
        JLabel k = anzahlGefundeneKunden;
        k.setPreferredSize(new Dimension(50,20));
        links.add(k, BorderLayout.NORTH);
        JScrollPane kundenListeSP = new JScrollPane(kundeJList);
        kundenListeSP.setPreferredSize(new Dimension(300,300));
        links.add(kundenListeSP, BorderLayout.SOUTH);
        return links;

    }

    /**
     * initiates new menubar
     *
     * @return JPanel menubar
     */

    private JMenuBar init_menuBar() {
        JMenuBar menueBar = new JMenuBar();
        JMenu menueReiter = new JMenu("Info");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(haupfenster, "Sergey Orlov, s0571777 \n Projekt: Magic Holliday Reiseagentur");
            }
        });
        menueReiter.add(about);
        menueBar.add(menueReiter);
        return menueBar;
    }
}
