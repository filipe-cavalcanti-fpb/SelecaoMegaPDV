from django.db import models

class Paragraph(models.Model):
    paragraph = models.TextField()

    def __unicode__(self):
        return self.paragraph[:50]+"..."

    def __str__(self):
        return self.paragraph[:50]+"..."

class About(models.Model):
    about_title = models.TextField(max_length=50)
    version = models.TextField(max_length=50)
    about_content = models.ManyToManyField(Paragraph)

    def __unicode__(self):
        return self.about_title

    def __str__(self):
        return self.about_title

class Home(models.Model):
    home_title = models.TextField(max_length=50)
    home_content = models.ManyToManyField(Paragraph)

    def __unicode__(self):
        return self.home_title

    def __str__(self):
        return self.home_title

class Help(models.Model):
    help_title = models.TextField(max_length=50)
    help_content = models.ManyToManyField(Paragraph)

    def __unicode__(self):
        return self.help_title

class Contac(models.Model):
    email = models.EmailField()
    nome = models.TextField()
    phone = models.TextField()
    contac_content = models.ManyToManyField(Paragraph)

    def __str__(self):
        return self.nome+"\n"+self.email