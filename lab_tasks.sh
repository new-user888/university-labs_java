for i in {1..6}; do
    git checkout Lab_$i
    git add Lab_$i
    git commit -m "Lab-0$i Implementation" 
    git push origin Lab_$i
done
 