Freesound Dataset Builder
=======================

This Java program provides functionality for downloading audio files from the Freesound API.
 
    
##How it Works

The Freesound Dataset Builder is an executable JAR file that logs into the [Freesound APIv2](http://www.freesound.org/docs/api/) on the user's behalf and automates the process of downloading raw audio files and the meta-data associated with them. 

**NEW USERS:** You must authorize the Freesound Dataset Builder to make API calls on your behalf by logging into the Freesound API with your Freesound account username and password. 

On the initial launch, the default web browser is opened automatically to the Freesound API login screen.  Once logged in, click "Authorize" and copy and paste the authorization code into the Freesound Dataset Builder.  After this initial authorization, a file named "refresh_token.json" will be generated and used to automate the authorization process for future runs. 

##Usage
To use the tool, simply open a Terminal, navigate to the directory containing the "freesound.jar" file, and append the following runtime arguments at launch:

    java -jar freesound.jar <KEYWORD_IN_QUOTES> <MIN_DURATION_IN_SECONDS> <MAX_DURATION_IN_SECONDS> <QUANTITY_TO_DOWNLOAD> <FILETYPE_IN_QUOTES>
    
**Examples:**

    java -jar freesound.jar "cell phone" 1 5 25 "*"
This will download 25 audio files of any format between 1 and 5 seconds long that contain the search term "cell phone".

    java -jar freesound.jar "barking" 3 15 30 "wav"
This will download 30 .wav audio files between 3 and 15 seconds long that contain the search term "barking".


##Requirements

Freesound Dataset Builder requires Java.  Download the latest version [here](http://www.java.com).
    
##Possible Issues

Segmenting by longest word from the left may cause trouble with singular nouns that pluralize with "-s" when the following word begins with an 's'.  For example:

    #diskspace => [disks pace]
    
Also, input text beginning with one-letter words may cause issues for the segmenter, either by incorrect segmentation or not segmenting it at all.  For example:

    #adinnertable => [ad inner table]
    #adentist => [adentist]
    
##Credits

HashTagSegmenter is based on Shyam Shankar's [Hashtag and URL Segmentation](https://github.com/shyam057cs/Machine-Learning/tree/master/Hashtag%20and%20Url%20Segmentation) script in Python.

Special thanks to Sheng Lundquist for his help with rewriting Shankar's script in Java and the Hashtable optimization.

Mentor: Dr. Garrett Kenyan

