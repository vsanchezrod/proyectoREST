package es.vsanchezrod.proyectorest.servicios.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TotalVO {
	
	private Number total;
	
	public Number getTotal() {
		return total;
	}

	public void setTotal(Number total) {
		this.total = total;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
