package com.appcreator.isa.theunitconverterapp;

import java.util.logging.LogRecord;

public class ConverterDataTransferRate
{
    public enum UnitsDataRateTransfer
    {
        Bit_Per_Second,
        Kilobit_Per_Second,
        Megabit_Per_Second,
        Gigabit_Per_Second,
        Terabit_Per_Second;

        private static LogRecord dlgAlert;

        // Helper method to convert text to one of the above constants
        public static UnitsDataRateTransfer fromString(String text)
        {
            if (text != null)
            {
                for (UnitsDataRateTransfer UnitsDataRateTransfer : UnitsDataRateTransfer.values())
                {
                    if (text.equalsIgnoreCase(UnitsDataRateTransfer.toString()))
                    {
                        return UnitsDataRateTransfer;
                    }
                }
            }

            throw new IllegalArgumentException("Cannot find a value for " + text);
        }
    }

    // What can I multiply by to get me from my fromUnitsDataRateTransfer to my toUnitsDataRateTransfer?
    private final double multiplier;

    public ConverterDataTransferRate(UnitsDataRateTransfer from, UnitsDataRateTransfer to)
    {
        double constant = 1;
        // Set the multiplier, else if fromUnitsDataRateTransfer = toUnitsDataRateTransfer, then it is 1
        switch (from)
        {
            case Bit_Per_Second:
                if (to == UnitsDataRateTransfer.Kilobit_Per_Second)
                {
                    constant = 0.001;
                } else if (to == UnitsDataRateTransfer.Megabit_Per_Second)
                {
                    constant = 1e-6;
                } else if (to == UnitsDataRateTransfer.Gigabit_Per_Second)
                {
                    constant = 1e-9;
                } else if (to == UnitsDataRateTransfer.Terabit_Per_Second)
                {
                    constant = 1e-12;
                }
                break;
            case Kilobit_Per_Second:
                if (to == UnitsDataRateTransfer.Bit_Per_Second)
                {
                    constant = 1000;
                } else if (to == UnitsDataRateTransfer.Megabit_Per_Second)
                {
                    constant = 0.001;
                } else if (to == UnitsDataRateTransfer.Gigabit_Per_Second)
                {
                    constant = 1e-6;
                } else if (to == UnitsDataRateTransfer.Terabit_Per_Second)
                {
                    constant = 1e-9;
                }
                break;
            case Megabit_Per_Second:
                if (to == UnitsDataRateTransfer.Bit_Per_Second)
                {
                    constant = 1e+6;
                } else if (to == UnitsDataRateTransfer.Kilobit_Per_Second)
                {
                    constant = 1000;
                } else if (to == UnitsDataRateTransfer.Gigabit_Per_Second)
                {
                    constant = 0.001;
                } else if (to == UnitsDataRateTransfer.Terabit_Per_Second)
                {
                    constant = 1e-6;
                }
                break;
            case Gigabit_Per_Second:
                if (to == UnitsDataRateTransfer.Bit_Per_Second)
                {
                    constant = 1e+9;
                } else if (to == UnitsDataRateTransfer.Kilobit_Per_Second)
                {
                    constant = 1e+6;
                } else if (to == UnitsDataRateTransfer.Megabit_Per_Second)
                {
                    constant = 1000;
                } else if (to == UnitsDataRateTransfer.Terabit_Per_Second)
                {
                    constant = 0.001;
                }
                break;
            case Terabit_Per_Second:
                if (to == UnitsDataRateTransfer.Bit_Per_Second)
                {
                    constant = 1e+12;
                } else if (to == UnitsDataRateTransfer.Kilobit_Per_Second)
                {
                    constant = 1e+9;
                } else if (to == UnitsDataRateTransfer.Megabit_Per_Second)
                {
                    constant = 1e+6;
                } else if (to == UnitsDataRateTransfer.Gigabit_Per_Second)
                {
                    constant = 1000;
                }
                break;
        }

        multiplier = constant;
    }

    // Convert the UnitsDataRateTransfer!
    public double convertDataRate(double input)
    {
        return input * multiplier;
    }
}