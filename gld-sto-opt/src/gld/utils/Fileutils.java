
/*-----------------------------------------------------------------------
 * Copyright (C) 2001 Green Light District Team, Utrecht University 
 *
 * This program (Green Light District) is free software.
 * You may redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by
 * the Free Software Foundation (version 2 or later).
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * See the documentation of Green Light District for further information.
 *------------------------------------------------------------------------*/

package gld.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * These functions can be used to add and remove elements from an array.
 *
 * @author Joep Moritz && Jilles V
 * @version 1.0
 */

public class Fileutils
{
    /**
     * Fetch the entire contents of a text file, and return it in a String. This
     * style of implementation does not throw Exceptions to the caller.
     * 
     * @param aFile
     *            is a file which already exists and can be read.
     */
    static public String getContents(File aFile)
    {
        // ...checks on aFile are elided
        StringBuilder contents = new StringBuilder();

        try
        {
            // use buffering, reading one line at a time
            // FileReader always assumes default encoding is OK!
            BufferedReader input = new BufferedReader(new FileReader(aFile));
            try
            {
                String line = null; // not declared within while loop
                /*
                 * readLine is a bit quirky : it returns the content of a line
                 * MINUS the newline. it returns null only for the END of the
                 * stream. it returns an empty String if two newlines appear in
                 * a row.
                 */
                while ((line = input.readLine()) != null)
                {
                    contents.append(line);
                    // contents.append(System.getProperty("line.separator"));
                }
            } finally
            {
                input.close();
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return contents.toString();
    }
}