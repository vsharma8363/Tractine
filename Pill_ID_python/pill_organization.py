import pandas as pd

pill_frame = pd.read_csv('Pillbox.csv')[['ID', 'author', 'medicine_name', 'spl_strength', 'spl_ingredients', 'rxstring', 'splimage', 'has_image']]
pill_img = pill_frame[pill_frame['has_image'] == True]
xlower = pill_img['medicine_name'].str.lower()
pill_img['medicine_name']  = xlower
pill_groupby = pill_img.groupby(by = 'medicine_name')
print(pill_groupby.to_string())