package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import com.google.cloud.Timestamp;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

@Entity(name = "books")
public class Device {
        @Id
        Long id;
        String macAdress;
        Date timestamp;

        public Device(String macAdress, Date timestamp) {
                this.macAdress = macAdress;
                this.timestamp = timestamp;
        }

        public long getId() {
                return this.id;
        }

        @Override
        public String toString() {
        	DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy",Locale.ENGLISH);
        	
                return "{" +
                                "id=" + this.id +
                                ", macAdress='" + this.macAdress + '\'' +
                                ", timestamp=" + dateFormat.format(this.timestamp) +
                                '}';
        }

		public boolean isCorrect() throws ParseException {
			
			return verifyMacAdress() && verifyTimeStamp();
			
		}

		private boolean verifyTimeStamp() throws ParseException {
		SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy",Locale.ENGLISH); 
		Date time=	objSDF.parse("01-01-2020");
		return this.timestamp.compareTo(time) > 0;
		}

		private boolean verifyMacAdress() {

			String regex 
            = "^([0-9A-Fa-f]{2}[:-])"
              + "{5}([0-9A-Fa-f]{2})|"
              + "([0-9a-fA-F]{4}\\."
              + "[0-9a-fA-F]{4}\\."
              + "[0-9a-fA-F]{4})$"; 
			
			Pattern p = Pattern.compile(regex); 
	        if (this.macAdress == null) { 
	            return false; 
	        } 
	        Matcher m = p.matcher(macAdress); 
	        return m.matches(); 
		}
}