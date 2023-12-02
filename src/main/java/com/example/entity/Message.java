package com.example.entity;

import javax.persistence.*;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * This is a class that models a Message.
 *
 * You should NOT make any modifications to this class.
 */
@Entity
@Table(name="message")
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Message {
     /**
     * An id for this message which will be automatically generated by the database.
     */
     @Column (name="message_id")
     @Id @GeneratedValue
    private Integer message_id;
    /**
     * The id for the user who has posted this message. We will assume that this is provided by the front-end of this
     * application.
     */
    @Column (name="posted_by")
    private Integer posted_by;
    /**
     * The text for this message- eg "this is my first post!". Must be not blank and under 255 characters
     */
    @Column (name="message_text")
    private String message_text;
    /**
     * The epoch time when this tweet was posted (number of seconds since Jan 1, 1970). Longs are large enough
     * to store this number. We will assume that this number is provided by the front-end of this application.
     */
    @Column (name="time_posted_epoch")
    private Long time_posted_epoch;
    /**
     * A default, no-args constructor, as well as correctly formatted getters and setters, are needed for
     * Jackson Objectmapper to work.
     */
    public Message(){
    }
    /**
     * When posting a new message, the id can be generated by the database. In that case, a constructor without
     * message_id is needed.
     * @param posted_by
     * @param message_text
     * @param time_posted_epoch
     */
    public Message(Integer posted_by, String message_text, Long time_posted_epoch) {
        this.posted_by = posted_by;
        this.message_text = message_text;
        this.time_posted_epoch = time_posted_epoch;
    }
    /**
     * Whem retrieving a message from the database, all fields will be needed. In that case, a constructor with all
     * fields is needed.
     * @param message_id
     * @param posted_by
     * @param message_text
     * @param time_posted_epoch
     */
    public Message(Integer message_id, Integer posted_by, String message_text, Long time_posted_epoch) {
        this.message_id = message_id;
        this.posted_by = posted_by;
        this.message_text = message_text;
        this.time_posted_epoch = time_posted_epoch;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @return message_id
     */
    public Integer getMessage_id() {
        return message_id;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @param message_id
     */
    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @return posted_by
     */
    public Integer getPosted_by() {
        return posted_by;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @param posted_by
     */
    public void setPosted_by(Integer posted_by) {
        this.posted_by = posted_by;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @return message_text
     */
    public String getMessage_text() {
        return message_text;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @param message_text
     */
    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @return time_posted_epoch
     */
    public Long getTime_posted_epoch() {
        return time_posted_epoch;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @param time_posted_epoch
     */
    public void setTime_posted_epoch(Long time_posted_epoch) {
        this.time_posted_epoch = time_posted_epoch;
    }
    /**
     * Overriding the default equals() method adds functionality to tell when two objects are identical, allowing
     * Assert.assertEquals and List.contains to function.
     * @param o the other object.
     * @return true if o is equal to this object.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (message_id == null) {
			if (other.message_id != null)
				return false;
		} else if (!message_id.equals(other.message_id))
			return false;
		if (message_text == null) {
			if (other.message_text != null)
				return false;
		} else if (!message_text.equals(other.message_text))
			return false;
		if (posted_by == null) {
			if (other.posted_by != null)
				return false;
		} else if (!posted_by.equals(other.posted_by))
			return false;
		if (time_posted_epoch == null) {
			if (other.time_posted_epoch != null)
				return false;
		} else if (!time_posted_epoch.equals(other.time_posted_epoch))
			return false;
		return true;
	}
	
    /**
     * Overriding the default toString() method allows for easy debugging.
     * @return a String representation of this class.
     */
    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", posted_by=" + posted_by +
                ", message_text='" + message_text + '\'' +
                ", time_posted_epoch=" + time_posted_epoch +
                '}';
    }


}
