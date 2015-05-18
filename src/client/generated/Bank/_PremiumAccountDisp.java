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

public abstract class _PremiumAccountDisp extends Ice.ObjectImpl implements PremiumAccount
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Bank::Account",
        "::Bank::PremiumAccount",
        "::Ice::Object"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[1];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String ice_staticId()
    {
        return __ids[1];
    }

    public final String getAccountNumber()
    {
        return getAccountNumber(null);
    }

    public final int getBalance()
    {
        return getBalance(null);
    }

    public final void transferMoney(String accountNumber, int amount)
        throws IncorrectAccountNumber,
            IncorrectAmount
    {
        transferMoney(accountNumber, amount, null);
    }

    public final void calculateLoan(int amount, Currency curr, int period, Ice.FloatHolder interestRate, Ice.IntHolder totalCost)
        throws IncorrectData
    {
        calculateLoan(amount, curr, period, interestRate, totalCost, null);
    }

    public static Ice.DispatchStatus ___calculateLoan(PremiumAccount __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        int amount;
        Currency curr;
        int period;
        amount = __is.readInt();
        curr = Currency.__read(__is);
        period = __is.readInt();
        __inS.endReadParams();
        Ice.FloatHolder interestRate = new Ice.FloatHolder();
        Ice.IntHolder totalCost = new Ice.IntHolder();
        try
        {
            __obj.calculateLoan(amount, curr, period, interestRate, totalCost, __current);
            IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeFloat(interestRate.value);
            __os.writeInt(totalCost.value);
            __inS.__endWriteParams(true);
            return Ice.DispatchStatus.DispatchOK;
        }
        catch(IncorrectData ex)
        {
            __inS.__writeUserException(ex, Ice.FormatType.DefaultFormat);
            return Ice.DispatchStatus.DispatchUserException;
        }
    }

    private final static String[] __all =
    {
        "calculateLoan",
        "getAccountNumber",
        "getBalance",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "transferMoney"
    };

    public Ice.DispatchStatus __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___calculateLoan(this, in, __current);
            }
            case 1:
            {
                return _AccountDisp.___getAccountNumber(this, in, __current);
            }
            case 2:
            {
                return _AccountDisp.___getBalance(this, in, __current);
            }
            case 3:
            {
                return ___ice_id(this, in, __current);
            }
            case 4:
            {
                return ___ice_ids(this, in, __current);
            }
            case 5:
            {
                return ___ice_isA(this, in, __current);
            }
            case 6:
            {
                return ___ice_ping(this, in, __current);
            }
            case 7:
            {
                return _AccountDisp.___transferMoney(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = 0L;
}
