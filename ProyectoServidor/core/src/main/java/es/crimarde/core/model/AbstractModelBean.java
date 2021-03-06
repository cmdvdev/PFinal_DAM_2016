package es.crimarde.core.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

@SuppressWarnings("serial")
public abstract class AbstractModelBean implements Serializable{

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);
    
    @Override
	public String toString() {
		return new ToStringBuilder(this).toString();
	}
    
}
