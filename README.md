# TSVFormat
Simple program to help with separating TSV data

This program is used to split TSV data for datasets that contain attributes that will go into multiple tables.

The Separator class contains several configuration variables that effect the execution of the program:
fileName - the file to be read from.
path - the file path to check.
multivalued - is one of the values multivalued?
cols - the columns to include in the generated file (Order matters).

The HandleFiles class is a simple file reader/writer.

The FieldSeparator class makes some assumptions about how the data is layed out. For example, the multivalued attribute is
currently always assumed to be the 1st column in the new file. This is so the copying of arrays is handled smoothly.

What this does NOT do:
- handle situations where there is more than one multivalued attribute needed (Though this would likely be separated into a 
  separate table anyways)
  
TODO:
- Add user input instead of source code modifications.
- Allow for the multivalued attribute to be a column other than the first.
- Some general cleanup, though this is low priority.
