// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `Bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package server.generated.Bank;

public class PersonalData implements java.lang.Cloneable, java.io.Serializable
{
    public String firstName;

    public String lastName;

    public String nationality;

    public String nationalIDNumber;

    public PersonalData()
    {
    }

    public PersonalData(String firstName, String lastName, String nationality, String nationalIDNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.nationalIDNumber = nationalIDNumber;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        PersonalData _r = null;
        if(rhs instanceof PersonalData)
        {
            _r = (PersonalData)rhs;
        }

        if(_r != null)
        {
            if(firstName != _r.firstName)
            {
                if(firstName == null || _r.firstName == null || !firstName.equals(_r.firstName))
                {
                    return false;
                }
            }
            if(lastName != _r.lastName)
            {
                if(lastName == null || _r.lastName == null || !lastName.equals(_r.lastName))
                {
                    return false;
                }
            }
            if(nationality != _r.nationality)
            {
                if(nationality == null || _r.nationality == null || !nationality.equals(_r.nationality))
                {
                    return false;
                }
            }
            if(nationalIDNumber != _r.nationalIDNumber)
            {
                if(nationalIDNumber == null || _r.nationalIDNumber == null || !nationalIDNumber.equals(_r.nationalIDNumber))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::Bank::PersonalData");
        __h = IceInternal.HashUtil.hashAdd(__h, firstName);
        __h = IceInternal.HashUtil.hashAdd(__h, lastName);
        __h = IceInternal.HashUtil.hashAdd(__h, nationality);
        __h = IceInternal.HashUtil.hashAdd(__h, nationalIDNumber);
        return __h;
    }

    public java.lang.Object
    clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(firstName);
        __os.writeString(lastName);
        __os.writeString(nationality);
        __os.writeString(nationalIDNumber);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        firstName = __is.readString();
        lastName = __is.readString();
        nationality = __is.readString();
        nationalIDNumber = __is.readString();
    }

    public static final long serialVersionUID = 881775615L;
}