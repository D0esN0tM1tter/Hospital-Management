package com.jee.business.facade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jee.Models.Document;
import com.jee.business.docs.DocServiceImp;
import com.jee.business.models.AdminBusiness;
import com.jee.business.models.DoctorBusiness;
import com.jee.business.models.PatientBusiness;
import com.jee.dao.manager.DaoFactory;

import jakarta.servlet.http.Part;

public class ApplicationFacade {

    private DocServiceImp docBusiness;
    private AdminBusiness adminBusiness ;
    private DoctorBusiness doctBusiness ;
    private PatientBusiness paBusiness ; 

    public ApplicationFacade() throws SQLException{
        this.docBusiness = new DocServiceImp(DaoFactory.createManager("Document")); 
        this.adminBusiness = new AdminBusiness(DaoFactory.createManager("Admin"));
        this.doctBusiness = new DoctorBusiness(DaoFactory.createManager("Doctor")); 
        this.paBusiness = new PatientBusiness(DaoFactory.createManager("Patient")); 
    }

    // Document related business : 
    public int insertDocument(Document doc , Part p) {
        return this.docBusiness.insertDocument(doc , p) ; 
    }

    public Document selDocument(int id ) throws FileNotFoundException, IOException {
        return this.docBusiness.selectDocument(id) ;
    }

    public void updateDocument(int docId , String newPath) throws SQLException {
         this.docBusiness.updateDocument(docId, newPath);
    }

    public int deleteDocument(int docId ) throws SQLException {
        return this.docBusiness.deleteDocument(docId);
    }

    // Admin related business : 
    public int insertAdmin(Object o) {
        return this.adminBusiness.insert(o); 
    }

    public Object selectAdmin(int id) {
        return this.adminBusiness.select(id);
    }

    public int updateAdmin(Document doc ) {
        return this.adminBusiness.update(doc);
    }

    public String deleteAdmin(int id) throws SQLException {
        return this.adminBusiness.delete(id) ;
    }

    public Boolean verifyAdmin(String login , String password ) {
        return this.adminBusiness.verify(login, password) ;  }

    // Doctor related business : 

    public int insertDoctor(Object o) {
        return this.doctBusiness.insert(o); 
    }

    public Object selectDoctor(int id) {
        return this.doctBusiness.select(id);
    }

    public int updateDoctor(Document doc ) {
        return this.doctBusiness.update(doc);
    }

    public String deleteDoctor (int id) throws SQLException {
        return this.doctBusiness.delete(id);
    }

    // Patient related business : 

    public int insertPatient(Object o) {
        return this.paBusiness.insert(o); 
    }

    public Object selectPatient(int id) {
        return this.paBusiness.select(id);
    }

    public int updatePatient(Document doc ) {
        return this.paBusiness.update(doc);
    }

    public String deletePatient (int id) throws SQLException {
        return this.paBusiness.delete(id);

    }
    
    public boolean authDoctor(String login, String password) {
    	return this.doctBusiness.verify(login, password);
    
}
    public List<Document> selectDocByIdAndType(int patientId , String type) {
        return this.docBusiness.selecByPidAndType(patientId, type);
    }}
