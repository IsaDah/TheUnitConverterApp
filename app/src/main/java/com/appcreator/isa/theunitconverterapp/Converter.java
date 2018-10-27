package com.appcreator.isa.theunitconverterapp;


import java.util.logging.LogRecord;

public class Converter
{
    public enum UnitsDistance
    {
        Inch,
        Centimetre,
        Foot,
        Yard,
        Metre,
        Mile,
        Kilometre,
        NauticalMile,
        Millimetre,
        Micrometre,
        Nanometre;

        private static LogRecord dlgAlert;

        // Helper method to convert text to one of the above constants
        public static UnitsDistance fromString(String text)
        {
            if (text != null)
            {
                for (UnitsDistance UnitsDistance : UnitsDistance.values())
                {
                    if (text.equalsIgnoreCase(UnitsDistance.toString()))
                    {
                        return UnitsDistance;
                    }
                }
            }

            throw new IllegalArgumentException("Cannot find a value for " + text);
        }
    }

    // What can I multiply by to get me from my fromUnitsDistance to my toUnitsDistance?
    private final double multiplier;

    public Converter(UnitsDistance from, UnitsDistance to)
    {
        double constant = 1;
        // Set the multiplier, else if fromUnitsDistance = toUnitsDistance, then it is 1
        switch (from)
        {
            case Inch:
                if (to == UnitsDistance.Centimetre)
                {
                    constant = 2.54;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 0.0833333;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 0.0277778;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 0.0254;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 1.5783e-5;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 2.54e-5;
                } else if (to == UnitsDistance.NauticalMile)
                {
                    constant = 1.3715e-5;
                }else if (to == UnitsDistance.Micrometre)
                {
                    constant = 25400;
                } else if (to == UnitsDistance.Millimetre)
                {
                    constant = 25.4;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 2.54e+7;
                }
                break;
            case Centimetre:
                if (to == UnitsDistance.Inch)
                {
                    constant = 0.393701;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 0.0328084;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 0.0109361;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 0.01;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 6.2137e-6;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 1e-5;
                } else if (to == UnitsDistance.NauticalMile)
                {
                    constant = 5.3996e-6;
                }else if (to == UnitsDistance.Micrometre)
                {
                    constant = 10000;
                } else if (to == UnitsDistance.Millimetre)
                {
                    constant = 10;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 1e+7;
                }
                break;
            case Foot:
                if (to == UnitsDistance.Inch)
                {
                    constant = 12;
                } else if (to == UnitsDistance.Centimetre)
                {
                    constant = 30.48;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 0.333333;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 0.3048;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 0.000189394;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 0.0003048;
                } else if (to == UnitsDistance.NauticalMile )
                {
                    constant = 0.000164579;
                }else if (to == UnitsDistance.Micrometre)
                {
                    constant = 304800;
                } else if (to == UnitsDistance.Millimetre)
                {
                    constant = 304.8;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 3.048e+8;
                }
                break;
            case Yard:
                if (to == UnitsDistance.Inch)
                {
                    constant = 36;
                } else if (to == UnitsDistance.Centimetre)
                {
                    constant = 91.44;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 3;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 0.9144;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 0.000568182;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 0.0009144;
                } else if (to == UnitsDistance.NauticalMile )
                {
                    constant = 0.000493737;
                }else if (to == UnitsDistance.Micrometre)
                {
                    constant = 914400;
                } else if (to == UnitsDistance.Millimetre)
                {
                    constant = 914.4;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 9.144e+8;
                }
                break;
            case Metre:
                if (to == UnitsDistance.Inch)
                {
                    constant = 39.3701;
                } else if (to == UnitsDistance.Centimetre)
                {
                    constant = 100;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 3.28084;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 1.09361;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 0.000621371;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 0.001;
                } else if (to == UnitsDistance.NauticalMile)
                {
                    constant = 0.000539957;
                }else if (to == UnitsDistance.Micrometre)
                {
                    constant = 1e+6;
                } else if (to == UnitsDistance.Millimetre)
                {
                    constant = 1000;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 1e+9;
                }
                break;
            case Mile:
                if (to == UnitsDistance.Inch)
                {
                    constant = 63360;
                } else if (to == UnitsDistance.Centimetre)
                {
                    constant = 160934;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 5280;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 1760;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 1609.34;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 1.60934;
                } else if (to == UnitsDistance.NauticalMile)
                {
                    constant = 1.1508;
                }else if (to == UnitsDistance.Micrometre)
                {
                    constant = 1.609e+9;
                } else if (to == UnitsDistance.Millimetre)
                {
                    constant = 1.609e+6;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 1.609e+12;
                }
                break;
            case Kilometre:
                if (to == UnitsDistance.Inch)
                {
                    constant = 39370.1;
                } else if (to == UnitsDistance.Centimetre)
                {
                    constant = 100000;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 3280.84;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 1093.61;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 1000;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 0.621371;
                } else if (to == UnitsDistance.NauticalMile)
                {
                    constant = 0.539957;
                }else if (to == UnitsDistance.Micrometre)
                {
                    constant = 1e+9;
                } else if (to == UnitsDistance.Millimetre)
                {
                    constant = 1e+6;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 1e+12;
                }
                break;
            case NauticalMile:
                if (to == UnitsDistance.Inch)
                {
                    constant = 72913.4;
                } else if (to == UnitsDistance.Centimetre)
                {
                    constant = 185200;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 6076.12;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 2025.37;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 1852;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 1.15078;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 1.852;
                }else if (to == UnitsDistance.Micrometre)
                {
                    constant = 1.852e+9;
                } else if (to == UnitsDistance.Millimetre)
                {
                    constant = 1.852e+6;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 1.852e+12;
                }
                break;

            case Millimetre:
                if (to == UnitsDistance.Inch)
                {
                    constant = 0.0393701;
                } else if (to == UnitsDistance.Centimetre)
                {
                    constant = 0.1;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 0.00328084;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 0.00109361;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 0.001;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 6.2137e-7;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 1e-6;
                }else if (to == UnitsDistance.Micrometre)
                {
                    constant = 1000;
                } else if (to == UnitsDistance.NauticalMile)
                {
                    constant = 5.3996e-7;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 1e+6;
                }
                break;

            case Micrometre:
                if (to == UnitsDistance.Inch)
                {
                    constant = 3.937e-5;
                } else if (to == UnitsDistance.Centimetre)
                {
                    constant = 1e-4;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 3.2808e-6;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 1.0936e-6;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 0.001;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 6.2137e-10;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 1e-9;
                }else if (to == UnitsDistance.Millimetre)
                {
                    constant = 0.001;
                } else if (to == UnitsDistance.NauticalMile)
                {
                    constant = 5.3996e-10;
                } else if (to == UnitsDistance.Nanometre)
                {
                    constant = 1000;
                }
                break;

            case Nanometre:
                if (to == UnitsDistance.Inch)
                {
                    constant = 3.937e-8;
                } else if (to == UnitsDistance.Centimetre)
                {
                    constant = 1e-7;
                } else if (to == UnitsDistance.Foot)
                {
                    constant = 3.2808e-9;
                } else if (to == UnitsDistance.Yard)
                {
                    constant = 1.0936e-9;
                } else if (to == UnitsDistance.Metre)
                {
                    constant = 1e-9;
                } else if (to == UnitsDistance.Mile)
                {
                    constant = 6.2137e-13;
                } else if (to == UnitsDistance.Kilometre)
                {
                    constant = 1e-12;
                }else if (to == UnitsDistance.Millimetre)
                {
                    constant = 1e-6;
                } else if (to == UnitsDistance.NauticalMile)
                {
                    constant = 5.3996e-13;
                } else if (to == UnitsDistance.Micrometre)
                {
                    constant = 0.001;
                }
                break;
        }

        multiplier = constant;
    }

    // Convert the UnitsDistance!
    public double convert(double input)
    {
        return input * multiplier;
    }

}