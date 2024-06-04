package org.enmovil.atf.util;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;

public class Utility {
	public static void upateMarkDelivered(String gcBillNo) {
		
		String connectionString = "mongodb://216.48.182.124:27024/ashokleyland_db";
		// Create a MongoClientURI object based on the connection string
		MongoClientURI uri = new MongoClientURI(connectionString);

		MongoClient mongoClient = new MongoClient(uri);

		// Get the database
		MongoDatabase database = mongoClient.getDatabase("ashokleyland_db");

		// Get the collection
		MongoCollection<Document> collection = database.getCollection("courierconsignments");

		// Define the update criteria (e.g., to update a document with "gc_waybill_no" field equal to 123)
		Document filter = new Document("gc_waybill_no", gcBillNo);

		// Define the update operation (e.g., to set a new value for the "fieldToUpdate"
		// field)
		Document update = new Document("$set", new Document("consignment_status", "Delivered"));

		// Update the document
		collection.updateOne(filter, update);

		System.out.println("Document updated successfully!");
	}
	
	public static String getGcBillFromCsvFile() {
		// Replace "your_csv_file.csv" with the path to your CSV file
		File consignmentFile = new File("src/main/resources/consignment-data/bulk_consignment_upload_test.csv");
		String filePath = consignmentFile.getAbsolutePath();
		int columnIndex = 4; // The column index you want to read (0-based index)

		List<String> columnData = readColumnData(filePath, columnIndex);
		//System.out.println(columnData.get(1));
		return columnData.get(1);
	}

	private static List<String> readColumnData(String filePath, int columnIndex) {
		List<String> columnData = new ArrayList<>();

		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				if (columnIndex < nextLine.length) {
					columnData.add(nextLine[columnIndex]);
				}
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return columnData;
	}
}

 
