package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date now = new Date();

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erros in reservation: Check-out date must be after Check-in date!");
		} 
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDate(Date checkIn, Date checkOut) {
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erros in reservation: Check-out date must be after Check-in date!");
		} 

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}

}
