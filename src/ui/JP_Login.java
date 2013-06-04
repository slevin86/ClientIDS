/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import client.rest.UtenteClient;
import com.google.gson.*;
import java.util.logging.*;
import org.codehaus.jettison.json.*;

/**
 *
 * @author giovanni
 */
public class JP_Login extends javax.swing.JPanel {

    /**
     * Creates new form JP_Login
     */
    public JP_Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_username = new javax.swing.JLabel();
        jtf_username = new javax.swing.JTextField();
        jl_password = new javax.swing.JLabel();
        jb_login = new javax.swing.JButton();
        jtf_password = new javax.swing.JPasswordField();

        jl_username.setText("Username");

        jl_password.setText("Password");

        jb_login.setText("Login");
        jb_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_loginActionPerformed(evt);
            }
        });

        jtf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jl_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_login)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_username)
                    .addComponent(jtf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_password)
                    .addComponent(jb_login)
                    .addComponent(jtf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public class Utente {
         public String id_utente;
         public String nome;
         public String cognome;
         public String azienda;
         public String cf_piva;
         public String via;
         public String citta;
         public String email;
         public String fax;
         public String telefono;
         public String cellulare;
         public String note;
         public String livello_utente;
         public String password;
         public String username;
    }
    
    private void jb_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_loginActionPerformed
        // TODO add your handling code here:
        int controllo = 0;
        UtenteClient client = new UtenteClient();
        String risposta = client.findAll_JSON(String.class);
        Gson gson = new GsonBuilder().create();
        JSONObject jso;
        try {
            jso = new JSONObject(risposta);
            JSONArray ja = jso.getJSONArray("utente");
            for (int i = 0; i < ja.length(); i++) {
               JSONObject jsonSection = ja.getJSONObject(i);
               Utente utente_ins = gson.fromJson(jsonSection.toString(), Utente.class);
               if (utente_ins.username.equals(jtf_username.getText())) {
                    i = ja.length();
                    if (utente_ins.password.equals(jtf_password.getText()))
                        controllo=1;
                    else
                        controllo=2;
               }
               else
                    controllo=3;
            }
            System.out.println(controllo);
        }
        catch (JSONException ex) {
            Logger.getLogger(JP_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        client.close();
    }//GEN-LAST:event_jb_loginActionPerformed

    private void jtf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_passwordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb_login;
    private javax.swing.JLabel jl_password;
    private javax.swing.JLabel jl_username;
    private javax.swing.JPasswordField jtf_password;
    private javax.swing.JTextField jtf_username;
    // End of variables declaration//GEN-END:variables
}
