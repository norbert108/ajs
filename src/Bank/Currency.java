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

package Bank;

public enum Currency implements java.io.Serializable
{
    
    PLN(0),
    
    EUR(1),
    
    USD(2),
    
    CHF(3);

    public int
    value()
    {
        return __value;
    }

    public static Currency
    valueOf(int __v)
    {
        switch(__v)
        {
        case 0:
            return PLN;
        case 1:
            return EUR;
        case 2:
            return USD;
        case 3:
            return CHF;
        }
        return null;
    }

    private
    Currency(int __v)
    {
        __value = __v;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeEnum(value(), 3);
    }

    public static Currency
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readEnum(3);
        return __validate(__v);
    }

    private static Currency
    __validate(int __v)
    {
        final Currency __e = valueOf(__v);
        if(__e == null)
        {
            throw new Ice.MarshalException("enumerator value " + __v + " is out of range");
        }
        return __e;
    }

    private final int __value;
}
