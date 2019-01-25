from django.utils import timezone
from django.shortcuts import render
from django.http import StreamingHttpResponse
from .models import *

def about(request):
    about = About.objects.all()
    return render(request, 'about/template_base.html', {'list_about': about})

def home(request):
    querySetHome = Home.objects.filter()
    return render(request, 'home/home_template.html', {"home_list": querySetHome})

def contact(request):
    querySetContact = Contac.objects.all()
    return render(request, 'contact/contact_template.html', {"contact_list": querySetContact})

def helpCardio(request):
    querySetHelp = Help.objects.all()
    return render(request, 'help/help_template.html', {"help_list": querySetHelp})

def runTestes(request):
    return render(request,'testes/testeExamn.html',{})