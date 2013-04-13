/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "AcuerdoMinuta")
@NamedQueries({
	@NamedQuery(name = "AcuerdoMinutaDO.findAll", query = "select rc from AcuerdoMinutaDO rc")
	})
public class AcuerdoMinutaDO implements Serializable{

}
