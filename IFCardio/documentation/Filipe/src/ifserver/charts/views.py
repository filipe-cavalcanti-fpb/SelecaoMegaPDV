from django.shortcuts import render
from .models import Examn

def examn(request):
    querySetMaster = Examn.objects.filter()
    return render(request, 'Examns_template.html',{'examns': querySetMaster})