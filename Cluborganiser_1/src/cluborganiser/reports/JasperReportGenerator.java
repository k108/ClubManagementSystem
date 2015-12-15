/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cluborganiser.reports;

import cluborganiser.services.ConnectDB;
import java.io.InputStream;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author admin
 */
public class JasperReportGenerator {

    String fileName;

    public JasperReportGenerator(String fileName) {
        this.fileName = fileName;
        generateReport();
    }

    public void generateReport() {
        try {
            InputStream is = getClass().getResourceAsStream(fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Connection con = ConnectDB.connect();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println("Exception in generationg report, generateReport() of JasperReportGenerator: " + e);
        }

    }
}
