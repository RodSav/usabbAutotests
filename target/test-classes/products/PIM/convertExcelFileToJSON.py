#!/usr/bin/python2.7
import xlrd
import xlwt
import json
import os.path
import sys

reload(sys)
sys.setdefaultencoding('utf-8')


def getColNames(sheet):
    rowSize = sheet.row_len(0)
    colValues = sheet.row_values(0, 0, rowSize)
    columnNames = []

    for value in colValues:
        columnNames.append(value)

    return columnNames


def getRowData(row, columnNames):
    rowData = {}
    counter = 0

    for cell in row:
        value = ""
        if type(cell.value) is float:
            value = int(cell.value)
        else:
            value = cell.value
        rowData[columnNames[counter]] = str(value).encode('utf-8').strip()
        counter += 1

    return rowData


def getSheetData(sheet, columnNames):
    nRows = sheet.nrows
    sheetData = []
    counter = 1

    for idx in range(1, nRows):
        row = sheet.row(idx)
        rowData = getRowData(row, columnNames)
        sheetData.append(rowData)

    return sheetData


def getWorkBookData(workbook, sheets):
    nsheets = workbook.nsheets
    counter = 0
    workbookdata = {}

    for idx in range(0, nsheets):
        worksheet = workbook.sheet_by_index(idx)
        if worksheet.name in sheets:
            column_names = getColNames(worksheet)
            sheetdata = getSheetData(worksheet, column_names)
            workbookdata[worksheet.name] = formatWorkBookData(sheetdata, worksheet.name)
    return workbookdata


def formatWorkBookData(sheetdata, worksheetname):
    data = []
    sheetsnames = {"BMT": "Base Model", "SKU": "SAP Material Description", "ProductCategories": "Base Model",
                   "ConfigurationPath": "Functional Category"}
    name = sheetsnames[worksheetname]
    for element in sheetdata:
        objectid = element[name]
        data.append({objectid: element})
    return data


def main():
    filename = raw_input("Enter the path to the filename -> ")

    if os.path.isfile(filename):
        workbook = xlrd.open_workbook(filename)
        workbookdata = getWorkBookData(workbook, {"BMT", "SKU", "ProductCategories", "ConfigurationPath"})
        output = \
            open((filename.replace("xlsx", "json")).replace("xls", "json"), "wb")
        output.write(json.dumps(workbookdata, skipkeys=True, sort_keys=True, indent=4, separators=(',', ": ")))
        output.close()
        print "%s was created" % output.name
    else:
        print "Sorry, that was not a valid filename"


"""
Convert PIM file to JSON. Get only data from BMT, SKU, Categories sheets
"""
main()
