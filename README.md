# PNEU-COV App
Android app that takes chest X-ray image as an input and predicts whether or not it is diagnosed with pneumonia.

# Start Activity

The first activity has the option of selecting your preffered language. Currently supporting English and Hindi.
<p align="center">
  <img src="https://github.com/ParvNarang/PNEU-COV-App/blob/34fc2725dd76cad954adb267fe0f32385aef2ac8/images/7.jpeg" width="350">
  <img src="https://github.com/ParvNarang/PNEU-COV-App/blob/d05e684f570c06760b7546372c354898081691ec/images/1.jpeg" width="350">
</p>

# Home Page

<p align="center">
  <img src="https://github.com/ParvNarang/PNEU-COV-App/blob/d05e684f570c06760b7546372c354898081691ec/images/2.jpeg" width="350">
  <img src="https://github.com/ParvNarang/PNEU-COV-App/blob/1d26027d768a18568f659d814bedbc357fea5feb/images/3.jpeg" width="350">
</p>

The model for detecting pneumonia was initially trained in python and was converted to .h5 model file. 
For importing it to Android Studio, tensorflow lite library is required and the h5 model has to be converted into .tflite file. 
The input image size is [224,224].
Upload the chest X-ray image using the upload button (which uses the media store library and uri library).
Click the select button to make the prediction.

# Result Page
As the select button is pressed it jumps on to the result activity.
The case below shows the chest X-ray image with pneumonia.
<p align="center">
  <img src="https://github.com/ParvNarang/PNEU-COV-App/blob/1284cb20647bbbfd9ff8950ac336e7c0bf873963/images/6.jpeg" width="350">
</p>

This shows the image with the normal case.
<p align="center">
  <img src="https://github.com/ParvNarang/PNEU-COV-App/blob/1284cb20647bbbfd9ff8950ac336e7c0bf873963/images/4.jpeg" width="350">
  <img src="https://github.com/ParvNarang/PNEU-COV-App/blob/1284cb20647bbbfd9ff8950ac336e7c0bf873963/images/5.jpeg" width="350">
</p>

# Future Plan
Add more models such as brain tumor detection, covid-19 detection.
