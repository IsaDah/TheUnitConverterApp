package com.appcreator.isa.theunitconverterapp;

import java.util.logging.LogRecord;

public class ConverterFrequency
{
    public enum UnitsFrequency
    {
        Hertz,
        Kilohertz,
        Megahertz,
        Gigahertz;

        private static LogRecord dlgAlert;

        // Helper method to convert text to one of the above constants
        public static UnitsFrequency fromString(String text)
        {
            if (text != null)
            {
                for (UnitsFrequency UnitsFrequency : UnitsFrequency.values())
                {
                    if (text.equalsIgnoreCase(UnitsFrequency.toString()))
                    {
                        return UnitsFrequency;
                    }
                }
            }

            throw new IllegalArgumentException("Cannot find a value for " + text);
        }
    }

    // What can I multiply by to get me from my fromUnitsFrequency to my toUnitsFrequency?
    private final double multiplier;

    public ConverterFrequency(UnitsFrequency from, UnitsFrequency to)
    {
        double constant = 1;
        // Set the multiplier, else if fromUnitsFrequency = toUnitsFrequency, then it is 1
        switch (from)
        {
            case Hertz:
                if (to == UnitsFrequency.Kilohertz)
                {
                    constant = 0.001;
                } else if (to == UnitsFrequency.Megahertz)
                {
                    constant = 1e-6;
                } else if (to == UnitsFrequency.Gigahertz)
                {
                    constant = 1e-9;
                }
                break;
            case Kilohertz:
                if (to == UnitsFrequency.Hertz)
                {
                    constant = 1000;
                } else if (to == UnitsFrequency.Megahertz)
                {
                    constant = 0.001;
                } else if (to == UnitsFrequency.Gigahertz)
                {
                    constant = 1e-6;
                }
                break;
            case Megahertz:
                if (to == UnitsFrequency.Hertz)
                {
                    constant = 1e+6;
                } else if (to == UnitsFrequency.Kilohertz)
                {
                    constant = 1000;
                } else if (to == UnitsFrequency.Gigahertz)
                {
                    constant = 0.001;
                }
                break;
            case Gigahertz:
                if (to == UnitsFrequency.Hertz)
                {
                    constant = 1e+9;
                } else if (to == UnitsFrequency.Kilohertz)
                {
                    constant = 1e+6;
                } else if (to == UnitsFrequency.Megahertz)
                {
                    constant = 1000;
                }
                break;
        }

        multiplier = constant;
    }

    // Convert the UnitsFrequency!
    public double convertFrequency(double input)
    {
        return input * multiplier;
    }

}

/*
    <string-array name="frequency">
        <item>Hertz</item>
        <item>Kilohertz</item>
        <item>Megahertz</item>
        <item>Gigahertz</item>
    </string-array>
 */