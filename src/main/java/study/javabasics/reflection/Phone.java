/**
 * 
 */
package study.javabasics.reflection;

import study.springframework.Person;

/**
 * @author jack
 *
 */
public class Phone {
	
	Integer id;
	String name;
	String deviceId;
	String phoneNumber;
	Person person;
	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", deviceId=" + deviceId + ", phoneNumber=" + phoneNumber
				+ ", person=" + person + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
