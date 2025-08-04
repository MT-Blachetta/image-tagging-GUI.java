# Image Tagging GUI

This project provides a small Swing-based application for annotating points
within image sequences. A series of images (e.g. `cell000.jpg`, `cell001.jpg`,
...) can be loaded and the user can click on each frame to record the
coordinates of an object of interest. The recorded positions are written to a
text file so the movement of the object can later be analysed.

## Features

- Displays JPEG or GIF images.
- Captures x/y coordinates of mouse clicks.
- Navigates forward and backward through a numbered image sequence.
- Stores tracked coordinates in a `track_<ID>.txt` file.

## Building and Running

The application requires a Java Development Kit (JDK 8 or newer).

```bash
javac -d bin src/GUI/*.java
java -cp bin GUI.MainClass
```

On start, use the **Datei → Öffnen** menu to select the first image of your
sequence. All images are expected to reside in the same directory and to follow
the naming scheme `cellNNN.jpg` with zero-padded indices.

## Usage

1. **Mark:** After loading an image sequence, press **START** to begin tracking.
2. Click on the image to record the position. The coordinates appear in the
   control panel.
3. Use **NEXT** (`→` key) and **Back** (`←` key) to step through the sequence.
4. When finished, press **Save** to close the track file.

The recorded positions are appended to `track_<ID>.txt`, where `<ID>` is the
value entered in the *cellNr* field.

## Purpose

The program is intended as a lightweight tool for manually tracking objects in
time-lapse image series, such as cells in microscopy recordings.

