package GUI;

/**
 * Phases of the application workflow.
 * INIT - awaiting the first image to be loaded.
 * WAIT - displaying images without recording coordinates.
 * MARK - recording click coordinates for each frame.
 */
public enum state {

         INIT, MARK, WAIT }


