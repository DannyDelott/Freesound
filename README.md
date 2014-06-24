Freesound Dataset Builder
=======================

This Java program provides functionality for downloading audio files from the Freesound API.
 
    
##How it Works

The Freesound Dataset Builder is an executable JAR file that logs into the Freesound API on the user's behalf and automates the process of downloading raw audio files and the meta-data associated with them. 

NEW USERS: You must authorize the Freesound Dataset Builder to make API calls on your behalf by logging into the Freesound API with your Freesound account username and password. On the initial launch, the default web browser is opened automatically to the Freesound API login screen.  Next, click "Authorize" and copy and paste the authorization code into the Freesound Dataset Builder.  After this initial authorization, a file named "refresh_token.json" will be generated and used to automate the authorization process on future runs. 

##Usage
To use the tool, simply open a Terminal, navigate to the directory containing "freesound.jar" and type:

    java -jar freesound.jar <KEYWORD_IN_QUOTES> <MIN_DURATION_IN_SECONDS> <MAX_DURATION_IN_SECONDS> <QUANTITY_TO_DOWNLOAD> <FILETYPE_IN_QUOTES>
    

##Note

If multiple segmentation outputs are possible, the longest word from the left is selected. For example:

    #alwaysahead => [always a head] and [always ahead]
    
This would return

    [always ahead]
    

If valid segments cannot be found, it returns the the original string without the '#' for hashtags. For example:

    #slamdunkkkk => [slamdunkkkk]

##Word List
The segmentation is based on a modified version of the list of 109,583 English words and word variations available here:

  (http://www-01.sil.org/linguistics/wordlists/english/)

Modifications to remove several common suffixes brought the list down to 109,551 words.  These suffixes can be found here:
    
  (http://en.wiktionary.org/wiki/Category:English_suffixes)

Numbers and decimals are segmented using regular expressions.
    
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

