/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author kappe
 */
public final class DataSerializer {

    public static final String DIRECTORY_NAME = "data\\";
    public static final String PROGRAMMERS_FILE = "Programmers.dat";
    public static final String CONSULTANTS_FILE = "Consultants.dat";
    public static final String ADMINISTRATORS_FILE = "Administrators.dat";
    public static final String COMPANIES_FILE = "Companies.dat";
    public static final String RECORDS_FILE = "Records.dat";
    private static final Logger LOG = Logger.getLogger(DataSerializer.class.getName());

    private DataSerializer() {
    }

    public static void SaveAllModels(ArrayList<Programmer> programmers, ArrayList<SecurityConsultant> consultants,
            ArrayList<Administrator> administrators, ArrayList<Company> companies, ArrayList<RentalRecord> records) {
        saveProgrammersToFile(programmers, PROGRAMMERS_FILE);
        saveConsultantsToFile(consultants, CONSULTANTS_FILE);
        saveAdministratorsToFile(administrators, ADMINISTRATORS_FILE);
        saveCompaniesToFile(companies, COMPANIES_FILE);
        saveRecordsToFile(records, RECORDS_FILE);
    }

    public static ArrayList<Programmer> loadProgrammersFromFile(String filename) {
        ArrayList<Programmer> programmers = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(DIRECTORY_NAME + filename);
            try ( ObjectInputStream inputFile = new ObjectInputStream(file)) {
                boolean endOfFile = false;
                while (!endOfFile) {
                    try {
                        programmers.add((Programmer) inputFile.readObject());
                    } catch (EOFException e1) {
                        endOfFile = true;
                    } catch (IOException | ClassNotFoundException e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            LOG.log(java.util.logging.Level.INFO, "File " + DIRECTORY_NAME + "{0} not found!\n", filename);
        }
        return programmers;
    }

    public static void saveProgrammersToFile(ArrayList<Programmer> programmers, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(DIRECTORY_NAME + filename);
            try ( ObjectOutputStream outputFile = new ObjectOutputStream(file)) {
                for (int i = 0; i < programmers.size(); i++) {
                    outputFile.writeObject(programmers.get(i));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ArrayList<SecurityConsultant> loadConsultantsFromFile(String filename) {
        ArrayList<SecurityConsultant> consultants = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(DIRECTORY_NAME + filename);
            try ( ObjectInputStream inputFile = new ObjectInputStream(file)) {
                boolean endOfFile = false;
                while (!endOfFile) {
                    try {
                        consultants.add((SecurityConsultant) inputFile.readObject());
                    } catch (EOFException e1) {
                        endOfFile = true;
                    } catch (IOException | ClassNotFoundException e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            LOG.log(java.util.logging.Level.INFO, "File " + DIRECTORY_NAME + "{0} not found!\n", filename);
        }
        return consultants;
    }

    public static void saveConsultantsToFile(ArrayList<SecurityConsultant> consultants, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(DIRECTORY_NAME + filename);
            try ( ObjectOutputStream outputFile = new ObjectOutputStream(file)) {
                for (int i = 0; i < consultants.size(); i++) {
                    outputFile.writeObject(consultants.get(i));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ArrayList<Administrator> loadAdministratorsFromFile(String filename) {
        ArrayList<Administrator> administrators = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(DIRECTORY_NAME + filename);
            try ( ObjectInputStream inputFile = new ObjectInputStream(file)) {
                boolean endOfFile = false;
                while (!endOfFile) {
                    try {
                        administrators.add((Administrator) inputFile.readObject());
                    } catch (EOFException e1) {
                        endOfFile = true;
                    } catch (IOException | ClassNotFoundException e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            LOG.log(java.util.logging.Level.INFO, "File " + DIRECTORY_NAME + "{0} not found!\n", filename);
        }
        return administrators;
    }

    public static void saveAdministratorsToFile(ArrayList<Administrator> administrators, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(DIRECTORY_NAME + filename);
            try ( ObjectOutputStream outputFile = new ObjectOutputStream(file)) {
                for (int i = 0; i < administrators.size(); i++) {
                    outputFile.writeObject(administrators.get(i));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ArrayList<Company> loadCompaniesFromFile(String filename) {
        ArrayList<Company> companies = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(DIRECTORY_NAME + filename);
            try ( ObjectInputStream inputFile = new ObjectInputStream(file)) {
                boolean endOfFile = false;
                while (!endOfFile) {
                    try {
                        companies.add((Company) inputFile.readObject());
                    } catch (EOFException e1) {
                        endOfFile = true;
                    } catch (IOException | ClassNotFoundException e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            LOG.log(java.util.logging.Level.INFO, "File " + DIRECTORY_NAME + "{0} not found!\n", filename);
        }
        return companies;
    }

    public static void saveCompaniesToFile(ArrayList<Company> companies, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(DIRECTORY_NAME + filename);
            try ( ObjectOutputStream outputFile = new ObjectOutputStream(file)) {
                for (int i = 0; i < companies.size(); i++) {
                    outputFile.writeObject(companies.get(i));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ArrayList<RentalRecord> loadRecordsFromFile(String filename) {
        ArrayList<RentalRecord> records = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(DIRECTORY_NAME + filename);
            try ( ObjectInputStream inputFile = new ObjectInputStream(file)) {
                boolean endOfFile = false;
                while (!endOfFile) {
                    try {
                        records.add((RentalRecord) inputFile.readObject());
                    } catch (EOFException e1) {
                        endOfFile = true;
                    } catch (IOException | ClassNotFoundException e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            LOG.log(java.util.logging.Level.INFO, "File " + DIRECTORY_NAME + "{0} not found!\n", filename);
        }
        return records;
    }

    public static void saveRecordsToFile(ArrayList<RentalRecord> records, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(DIRECTORY_NAME + filename);
            try ( ObjectOutputStream outputFile = new ObjectOutputStream(file)) {
                for (int i = 0; i < records.size(); i++) {
                    outputFile.writeObject(records.get(i));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
