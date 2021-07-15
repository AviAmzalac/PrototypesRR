import matplotlib.pyplot as plt
import os
import numpy as np

cur_path = os.path.dirname(__file__)
new_path = os.path.relpath('../tries', cur_path)  # path relatif du contenus de tries
entries = os.listdir(new_path)  # nom de tous les fichiers


def createMainArray(nb_row):
    mainArray = []
    for i in range(nb_row):
        mainArray.append([])
    return mainArray


def createListOfAllArrays():
    listOfLists = []
    for i in entries:
        fileObj = open(new_path + '/' + i, "r")
        words = fileObj.read().splitlines()
        fileObj.close()
        treated = [int(x) for x in words]
        listOfLists.append(treated)
    numpyArray = np.array(listOfLists)
    return numpyArray


def Main():
    # Va contenir les tableau des 1ers elements, 2nd, 3eme, etc...
    mainArray = createMainArray(200)
    # Va contenir les tableaux d'entier des fichiers
    numpyArray = createListOfAllArrays()
    for j in range(numpyArray[0].size):
        mainArray[j] = (numpyArray[:, j])
    mainArray = np.array(mainArray)
    print(mainArray)
    plt.figure(figsize=(30,7))
    boxesprops=dict(linewidth=0.1)
    whiskersprops=dict(linewidth=0.1)
    medianprops=dict(linewidth=0.1)
    capprops=dict(linewidth=0.1)
    flierprops=dict(linewidth=0.1)
    for i in mainArray:
        ax = plt.boxplot(mainArray.tolist(),
                         boxprops=boxesprops,
                         whiskerprops=whiskersprops,
                         medianprops=medianprops,
                         capprops=capprops,
                         flierprops=flierprops)

    plt.savefig('/tmp/output/diag.png')
Main()

