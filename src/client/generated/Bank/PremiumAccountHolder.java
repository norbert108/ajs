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

package client.generated.Bank;

public final class PremiumAccountHolder extends Ice.ObjectHolderBase<PremiumAccount>
{
    public
    PremiumAccountHolder()
    {
    }

    public
    PremiumAccountHolder(PremiumAccount value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        if(v == null || v instanceof PremiumAccount)
        {
            value = (PremiumAccount)v;
        }
        else
        {
            IceInternal.Ex.throwUOE(type(), v);
        }
    }

    public String
    type()
    {
        return _PremiumAccountDisp.ice_staticId();
    }
}