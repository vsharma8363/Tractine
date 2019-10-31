import os
import cv2

home_dir = 'pillbox_img'
directory = os.fsencode(home_dir)

i = 0

def extract_pill(original, testing=False):
    # Median blur to remove noise from the image
    blur = cv2.medianBlur(original, 21)

    # Greyscale the image
    grey = blur

    # Threshold the image
    thresh = cv2.Canny(grey, 30, 200)

    # Find all contours
    contours, hierarchy = cv2.findContours(thresh, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

    # Extract and crop to the largest box (most likely the pill)
    if len(contours) <= 0:
        return original

    c = max(contours, key=cv2.contourArea)
    x, y, w, h = cv2.boundingRect(c)
    extracted_pill = original[y:y + h, x:x + w]

    if testing:
        cv2.imwrite('original.jpg', original)
        cv2.imwrite('extracted.jpg', extracted_pill)

    return extracted_pill

for file in os.listdir(directory):
    # Load image from the database
    pill_file_path = os.fsdecode(file)
    original = cv2.imread(os.path.join(home_dir, pill_file_path))
    extracted_pill = extract_pill(original)

    cv2.imwrite(os.path.join('extracted_pills', pill_file_path), extracted_pill)